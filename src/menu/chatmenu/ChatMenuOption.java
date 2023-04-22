package menu.chatmenu;

import menu.*;
import java.util.*;

public class ChatMenuOption extends Option {
    public ChatMenuOption(String nome, Object content) {
        this.nome = nome;
        this.content = content;
        this.keywords.add(this.nome);
    }

    public ChatMenuOption(String nome, Object content, List<String> keywords) {
        this.nome = nome;
        this.content = content;
        this.keywords = keywords;
        this.keywords.add(this.nome);
    }

    @Override
    public Object select(Menu selector) {
        return content;
    }
}
