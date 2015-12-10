package pl.kaczor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.Desktop;

public class Trojmiasto {
    private static final String ADRES = "http://konkursy.trojmiasto.pl/konkurs-";
    private static final String IDKI = "C:/Users/mateusz.kaczmarek/trojmiasto_idki.txt";
    private static final String LOG = "C:/Users/mateusz.kaczmarek/trojmiasto_log.txt";
    private static final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy3.mbicb.pl", 8080));

    public static void main(String[] args) throws IOException {

        while (true) {
            List<String> idki = Files.readAllLines(Paths.get(IDKI));
            List<String> idkiKopia = new ArrayList<String>();

            for (int i = 0; i < idki.size(); i++) {
                String id = idki.get(i);
                String idPlusOne = String.valueOf(Integer.valueOf(id) + 1);
                System.out.println("Sprawdzam id " + id);
                URL url = new URL(ADRES + id);
                URLConnection conn = url.openConnection(proxy);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String inputLine;
                State state = State.OTHER;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("<h2>Konkurs rozstrzyg") || inputLine.contains("<h2>Konkurs zako")) {
                        state = State.FINISHED;
                    } else if (inputLine.contains("<h3>Nie znaleziono konkursu")) {
                        state = State.NOT_FOUND;
                    } else if (inputLine.contains("<h3>Twoja odpowie") || inputLine.contains("<h3>Twoja wypowie")) {
                        state = State.FOUND;
                    }
                    if (state != State.OTHER) {
                        break;
                    }
                }
                System.out.println("Stan: " + state.name());

                if (i == 0) {
                    if (state == State.FOUND) { // znaleziono - wyswietl i przejdz do nastepnego id
                        showAndLog(id);
                        idkiKopia.add(idPlusOne);
                    } else if (state == State.NOT_FOUND) { // jeszcze nie ma - zostaw na miejscu
                        idkiKopia.add(id);
                    } else { // inna sytuacja (blad?) - pomin, sprawdzaj w przyszlosci, a tymczasem przejdz do nastepnego id
                        idkiKopia.add(idPlusOne);
                        idkiKopia.add(id);
                    }
                } else {
                    if (state == State.FOUND) { // znaleziono - wyswietl, nie sprawdzaj dalej
                        showAndLog(id);
                    } else if (state == State.FINISHED) { // zakonczony - nie sprawdzaj dalej
                        continue;
                    } else { // inna sytuacja - sprawdzaj dalej
                        idkiKopia.add(id);
                    }
                }
            }

            System.out.println("Zapisuje do pliku: " + idkiKopia.toString());
            Files.write(Paths.get(IDKI), idkiKopia);

            try {
                System.out.println("czekam 30 sekund od..." + Calendar.getInstance().getTime().toString());
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    enum State {
        OTHER, FINISHED, NOT_FOUND, FOUND;
    }

    private static void showAndLog(String id) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(ADRES + id));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(LOG), StandardOpenOption.APPEND)) {
            writer.write(ADRES + id + " " + Calendar.getInstance().getTime().toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
