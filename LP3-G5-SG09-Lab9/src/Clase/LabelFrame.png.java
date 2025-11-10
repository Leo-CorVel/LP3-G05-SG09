package Clase;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JLabel etiqueta3;
	
	public LabelFrame() {
		super("Prueba de Jabel");
		setLayout(new FlowLayout());
		
		etiqueta1=new JLabel("Etiqueta con texto");
		etiqueta1.setToolTipText("Esta es etiqueta");
		add(etiqueta1);
		
		Icon insecto=new ImagenIcon(getClass().getResource("insecto1.png"));
		etiqueta2=new JLabel("Etiqueta con texto e icono",insecto,SwingConstants.LEFT);
		etiqueta2.setToolTipText("Esta es etiqueta2");
		
		etiqueta3=new JLabel();
		etiqueta3.setText("Etiqueta con icono y texto en la parte inferior");
		etiqueta3.setIcon(insecto);
		etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER);
		etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM);
		etiqueta3.setToolTipText("Esta es etiqueta 3");
		add(etiqueta3);
	}
	
	
	
	
	
}
