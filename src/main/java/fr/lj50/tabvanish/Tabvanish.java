package fr.lj50.tabvanish;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "tabvanish",
        name = "Tabvanish",
        description = "Cache les joueurs vanish de l'auto-complétition du tab",
        authors = {
                "lejoueur50"
        }
)
public class Tabvanish {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("TabVanish pret !");
        Sponge.getEventManager().registerListeners(this, new gestionTabCompleteEvent());
    }

}
