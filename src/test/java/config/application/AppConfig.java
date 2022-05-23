package config.application;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/application/app.properties"
})
public interface AppConfig extends Config {
    @Key("remote.web.user")
    String getRemoteWebUser();

    @Key("remote.web.password")
    String getRemoteWebPassword();

    @Key("remote.web.token")
    String getRemoteWebToken();
}