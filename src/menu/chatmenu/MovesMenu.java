package menu.chatmenu;

import chars.Charac;
import moves.*;
import menu.Command;
import java.util.*;
import usable.Usable;

public class MovesMenu extends ChatMenu {
    private Charac personagem;

    public MovesMenu(Charac personagem) {
        super("Movimentos");
        List<Move> movimentos = personagem.getMovimentos();
        for (Move move : movimentos) {
            options.add(new MoveOption(move));
        }
    }

    class MoveOption extends ChatMenuOption {
        private Move move;

        public MoveOption(Move move) {
            super(move.getNome(), move);
            this.move = move;
        }
    }
}
