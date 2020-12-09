package fr.lj50.tabvanish;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.command.TabCompleteEvent;

import java.util.Collection;


public class gestionTabCompleteEvent {

    @Listener
    public void onTabCompleteEvent(TabCompleteEvent event) {

        Object sender = event.getSource();

        if(sender instanceof Player) {//Doit être un joueur en jeu

            if (!((Player) sender).hasPermission("tabvanish.bypass")) {//S'il n'a pas la perm, je retire les staffs

                Collection playersOnline = Sponge.getServer().getOnlinePlayers();//Tous les joueurs en ligne
                Object[] online = playersOnline.toArray();//Tous les joueurs en array, itérable
                for(int i=0; i<online.length; i++){
                    Player player= (Player) online[i];//Joueurs récupérés 1 par 1 ( tous les joueurs )
                    if(player.hasPermission("tabvanish.hide")){
                        event.getTabCompletions().remove(player.getName());//Je retire le pseudo du joueur de la liste de choix proposés
                    }
                }
            }
        }
    }
}
