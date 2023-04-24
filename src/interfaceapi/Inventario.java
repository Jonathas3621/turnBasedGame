package interfaceapi;

public class Inventario {
    public static void main(String[] args) {
	int SIZE_X = 48;
	int SIZE_Y = 28;
	Janela janela = new Janela(SIZE_X, SIZE_Y);
	janela.drawBorder();

	janela.writeTitle("INVENTÁRIO");

	Janela sessions_panel = new Janela(SIZE_X, SIZE_Y-2);
	sessions_panel.drawBorder();
	
	janela.add(sessions_panel);
	sessions_panel.setPos(0, 2);

	Janela selected_session = new Janela(14, 3);
	selected_session.drawBorder();
	janela.add(selected_session);
	selected_session.setPos(1, 1);
	selected_session.writeCenter("ARMAS");

	Janela selected_session2 = new Janela(14, 3);
	selected_session2.transparency = true;
	//selected_session2.drawBorder();
	janela.add(selected_session2);
	selected_session2.setPos(15, 1);
	selected_session2.writeCenter("ARMADURAS");
	

	janela.print();
    }
}
