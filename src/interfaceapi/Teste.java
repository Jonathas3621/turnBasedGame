package interfaceapi;

public class Teste {
    public static void main(String[] args) {
	Janela window = new Janela(49, 9);
	window.drawBorder();

	window.setChar('L', 3, 1);
	window.setChar('u', 8, 2);
	window.setChar('c', 5, 3);
	window.setChar('a', 9, 4);
	window.setChar('s', 12, 5);
	window.write("1 3 3 7", 3, 7);
	window.drawWall('.', 16, 1, 15, 7);
	window.drawCollum(15, 0, 9);
	window.drawLine(1, 6, 14);
	window.write("MAGIC", 4, 6);
	window.setChar('$', 15, 0);
	window.setChar('$', 15, 8);

	Janela window2 = new Janela(11, 5, 19, 1);
	window2.drawBorder();
	window2.write("ITEMS", 3, 1);
	window2.write("*Sword", 2, 2);
	window2.write("*Shield", 2, 3);

	Janela window3 = new Janela(32, 7, 16, 1);
	window.add(window3);
	window3.drawBorder();
	window3.add(window2);

	Janela composite_window = new Janela(11, 4);
	composite_window.drawBorder();
	composite_window.write("COMPOSITE", 1, 2);
	composite_window.write("ADDED", 3, 1);
	window3.add(composite_window);
	composite_window.setPos(4, 2);

	window.print();
    }
}
