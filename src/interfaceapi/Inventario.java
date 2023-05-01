package interfaceapi;

public class Inventario {
    public static void main(String[] args) {
	int SIZE_X = 48;
	int SIZE_Y = 28;
	Janela janela = new Janela(SIZE_X, SIZE_Y); janela.drawBorder(); janela.writeTitle("INVENTÁRIO");

	Janela sessions_panel = new Janela(SIZE_X, SIZE_Y-2);
	sessions_panel.drawBorder();
	
	janela.add(sessions_panel);
	sessions_panel.setPos(0, 2);

	Janela selected_session = new Janela(14, 3);
	selected_session.drawBorder();
	janela.add(selected_session);
	selected_session.setPos(1, 1);
	selected_session.writeCenter("ARMAS");

	//Janela selected_session2 = new Janela(14, 3);
	//selected_session2.transparency = true;
	//selected_session2.drawBorder();
	//janela.add(selected_session2);
	//selected_session2.setPos(15, 1);
	//selected_session2.writeCenter("ARMADURAS");
	
	//janela.write("ARMADURAS", 17, 2); Notas: criar uma janela de Texto
	
	sessions_panel.write("ARMADURAS", 19, 0);
	sessions_panel.write("COMIDAS", 34, 0);

	Janela status = new Janela(SIZE_X/2, 9, 0, SIZE_Y-9);
	janela.add(status);
	status.drawBorder();
	status.writeTitle("STATUS");

	status.write("Dano: 32", 2, 1);
	status.write("Velocidade: 12", 2, 2);
	status.write("Tipo: Espada Longa", 2, 3);
	status.write("Afndades: Fogo, Água", 2, 4);
	status.write("Runas: [3A] [EF]", 2, 5);

	status.write("Peso: 1.25kg", 2, 6);
	status.write("Raridade: Rara", 2, 7);

	Janela descricao = new Janela(SIZE_X/2, 9, SIZE_X/2, SIZE_Y-9);
	janela.add(descricao);
	descricao.drawBorder();
	descricao.writeTitle("DESCRICAO");
	descricao.write("Uma katana forjada ", 2, 1);
	descricao.write("pelo próprio Gran- ", 2, 2);
	descricao.write("-Ferreiro Jogular", 2, 3);

	janela.print();
    }
}
