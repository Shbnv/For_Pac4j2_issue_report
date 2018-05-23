package how.pac4j2;

import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.pac4j.Pac4j;
import org.pac4j.http.client.indirect.FormClient;
import org.pac4j.http.credentials.authenticator.test.SimpleTestUsernamePasswordAuthenticator;
import org.pac4j.oauth.client.FacebookClient;

import java.io.FileInputStream;

/**
 * @author jooby generator
 */
public class App extends Jooby {

   {
    get("/login", () ->
      {
        Result res = new Result();
        res.type( "text/html" );
        res.set( new FileInputStream( "public/login.html" ) );
        return res;
      });
    use( new Pac4j()
          // If comment any row bellow - program work correctly
          .client( conf-> new FormClient( "/login", new SimpleTestUsernamePasswordAuthenticator() ) )
          .client( conf-> new FacebookClient( "lalala", "lololo!" ))
    );
    get("/", () -> "Hi. World!");
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
