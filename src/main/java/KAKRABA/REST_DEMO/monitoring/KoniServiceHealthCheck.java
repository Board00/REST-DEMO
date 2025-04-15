package KAKRABA.REST_DEMO.monitoring;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;


@Controller
public class KoniServiceHealthCheck implements HealthIndicator {

    @Autowired
    private Environment env;

    @Override
    public Health health()
    {
        try {
            if (isServiceUp()) {
                return Health.up().withDetail("Koni Service", "is working good").build();
            } else {
                return Health.down().withDetail("Koni Service", "is DOWN").build();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    private boolean isServiceUp() throws IOException {
        String address = env.getProperty("koniService.address");
        String port = env.getProperty("koniServiceport");

        return isAddressReachable(address, Integer.parseInt(port), 3000);
    }

    private static boolean isAddressReachable(String address, int port, int timeout)
            throws IOException {
        try (Socket isSocket = new Socket()) {
            // Connects this socket to the server with a specified timeout value.
            isSocket.connect(new InetSocketAddress(address, port), timeout);
            // Return true if connection successful
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            // Return false if connection fails
            return false;
        }
    }


}
