import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;


public class nach {

	public static void main(String[] args) {
		SizeOkno sizeO = new SizeOkno();
		sizeO.size();
		myFrame okno = new myFrame();
		okno.setSize(sizeO.screenSizeW, sizeO.screenSizeH-40);
		okno.setResizable(false);
		
	}

}

 class SizeOkno{
	void size(){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	screenSizeW = screenSize.width;
    	screenSizeH = screenSize.height;
	}
	static int screenSizeW;
	static int screenSizeH;
	
}
class myFrame extends JFrame {
	static int nachGame = 0;
	static int menu = 0;
	public myFrame(){
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("C:\\GameJava\\cursor.png").getImage(),
				new Point(0,0),"custom cursor"));
		
		MenuPanel panelMenu1 = new MenuPanel();
		panelMenu1.setLayout(null);
		
		MenuPanel panelMenu2 = new MenuPanel();
		panelMenu2.setLayout(null);
		
		gamePanel panelGame = new gamePanel();
		panelGame.setLayout(null);
		
		panelGame.setSize(5000, 5000);
		Container cont = getContentPane();
		
		
		cont.add(panelMenu1);
		
		setTitle("Игра");
		setVisible(true);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		
        JButton ContinueButt = new JButton();
		
        ContinueButt.setSize(192,48);
        ContinueButt.setLocation((SizeOkno.screenSizeW/2-100),(SizeOkno.screenSizeH/2-300));
        ContinueButt.setIcon(new ImageIcon("C:\\GameJava\\butcont.jpg"));
        ContinueButt.setBorderPainted(false);
        ContinueButt.setFocusPainted(false);
        ContinueButt.setContentAreaFilled(false);
        ContinueButt.setRolloverIcon(new ImageIcon("C:\\GameJava\\butcontup.jpg" ));
        ContinueButt.setPressedIcon (new ImageIcon("C:\\GameJava\\butcontup.jpg"));
        ContinueButt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
        panelMenu1.add(ContinueButt);
		
		JButton buttNewGame = new JButton();
		
		buttNewGame.setSize(192,48);
		buttNewGame.setLocation((SizeOkno.screenSizeW/2-100),(SizeOkno.screenSizeH/2-200));
		buttNewGame.setIcon(new ImageIcon("C:\\GameJava\\butnewgame.jpg"));
		buttNewGame.setBorderPainted(false);
		buttNewGame.setFocusPainted(false);
		buttNewGame.setContentAreaFilled(false);
		buttNewGame.setRolloverIcon(new ImageIcon("C:\\GameJava\\butnewgameup.jpg" ));
		buttNewGame.setPressedIcon (new ImageIcon("C:\\GameJava\\butnewgameup.jpg"));
		buttNewGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cont.remove(panelMenu1);
			    cont.add(panelMenu2);
			    repaint();
			    revalidate(); 
			    menu++;
			}
			
		});

		panelMenu1.add(buttNewGame);
		
		JButton buttExit = new JButton();
		buttExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		buttExit.setSize(192,48);
		buttExit.setLocation((SizeOkno.screenSizeW/2-100),(SizeOkno.screenSizeH/2-100));
		buttExit.setIcon(new ImageIcon("C:\\GameJava\\butexit.jpg"));
		buttExit.setBorderPainted(false);
		buttExit.setFocusPainted(false);
		buttExit.setContentAreaFilled(false);
		buttExit.setRolloverIcon(new ImageIcon("C:\\GameJava\\butexitup.jpg" ));
		buttExit.setPressedIcon (new ImageIcon("dC:\\GameJava\\butexitup.jpg"));
        panelMenu1.add(buttExit);
		
		 
		JButton buttVoin = new JButton();
		buttVoin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cont.remove(panelMenu2);
			    cont.add(panelGame);
			    repaint();
			    revalidate();
			    myFrame.nachGame++;
			}
			
		});
		buttVoin.setSize(248,400);
		buttVoin.setLocation((SizeOkno.screenSizeW/2-300),(SizeOkno.screenSizeH/2-300));
		buttVoin.setIcon(new ImageIcon("C:\\GameJava\\voinN.png"));
		panelMenu2.add(buttVoin);
		
		JButton buttStrelok = new JButton();
		buttStrelok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cont.remove(panelMenu2);
			    cont.add(panelGame);
			    repaint();
			    revalidate();
			    myFrame.nachGame--;
			}
			
		});
		buttStrelok.setSize(248,400);
		buttStrelok.setLocation((SizeOkno.screenSizeW/2+100),(SizeOkno.screenSizeH/2-300));
		buttStrelok.setIcon(new ImageIcon("C:\\GameJava\\strelokV.png"));
		panelMenu2.add(buttStrelok);
		
		
		JButton butt3 = new JButton();
		butt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		butt3.setSize(50,50);
		butt3.setLocation(0,0);
		butt3.setIcon(new ImageIcon("C:\\GameJava\\ex.png"));
		butt3.setBorderPainted(false);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(false);
        butt3.setRolloverIcon(new ImageIcon("C:\\GameJava\\ex.png" ));
        butt3.setPressedIcon (new ImageIcon("C:\\GameJava\\ex.png"));
		panelGame.add(butt3);
		
		
		
	}
}

class MenuPanel extends JPanel {
	Image fon;
	public MenuPanel(){
		try {
			fon = ImageIO.read(new File("C:\\GameJava\\wall0011.jpg"));
		} catch (IOException e) {
			
		}
		
	}
	public void paintComponent(Graphics gr) {
		for (int i = 0; i<=SizeOkno.screenSizeW; i++){
			for (int j = 0; j<=SizeOkno.screenSizeH; j++){
			gr.drawImage(fon, i, j, 500, 500, null);
			j+=499;
			}
			i+=499;
		}
		
	}
}

class gamePanel extends JPanel{
	Image fon, portraitImage1, portraitImage2,bar;
	Image voinImg, nameHero1;
	Image strelokImg,nameHero2;
	Image castle,goldStatus,goldFon;
	Image tropa1Img, tropa2Img;
	Image castleMess;
	Image slotVoisk;
	Image tree1, wall,ex,cosmos;
	Image[] voisko = new Image[2];
	Image[] spawn = new Image[8];
	Image[] walkA = new Image[8];
	Image[] walkK = new Image[8];
	Image[] treeS = new Image[4];
	Image rock, rockCenter;
	Image strelkaVverh;
	Image strelkaPravo;
	Image[] treasure = new Image[6];
	Image[] rockTree = new Image[6];
	int x=325,y=475, chislo;
	int randX;
	int randY;
	int[] centerSpawnX = new int[16];
	int[] centerSpawnY = new int[16];
	int[] masDvij = new int[100];
	int dvij11 = 0;
	int[] KolVoisk = new int[20];
	int oldx = 300, oldy = 450;
	int[][] pole = new int[41][23];
	boolean[][] vijn = new boolean[42][20];
	boolean click = false;
	boolean drSp = false;
	int time = -1;
	int prob = 0;
	int chet = 0;
	boolean dvij = false;
	int c = -1;
	int kolPut = -1;
	int numShag = -1;
	int Nx = oldx/50;
	int Ny = oldy/50;
	int rez = 0;
	int f1 = 0;
	int f2 = 0;
	int f = 0;
	int u = 0;
	int sh =0;
	int kShag1 = 0;
	int kShag2 = 0;
	int GoldLabel = 0;
	boolean castleMessVisible = false;
	int[][] masPut = new int[400][100];
	Font font = new Font("Verdana", Font.PLAIN, 18);
	Font font2 = new Font("Italic", Font.PLAIN, 16);
	Color goldColor = new Color(240, 255, 0);
	JLabel goldLabel = new JLabel();
	JLabel[] kolVoiskLabel = new JLabel[20];  
	public int[][] getMas(){
		
		return(pole);
	}
	
	
	
	public void UpdateGoldLabel(JLabel label){
		label.setText(""+hero.getGold());
	}
	public void UpdateVoiskoLabel(JLabel[] label, int i){
		label[i].setText(""+KolVoisk[i]);
		if(KolVoisk[i]!=0){
			label[i].setVisible(true);
		}
	}
	int proverkaPut(int x, int y){
		
		for(int i = 0; i <=kolPut; i++){
			Nx = oldx/50;
		    Ny = oldy/50;
			for(int j = 0; j<=numShag; j++){
				if(masPut[i][j]==1){	
					Nx++;
				}
				if(masPut[i][j]==-1){
					Nx--;
				}
				if(masPut[i][j]==2){
					Ny++;
				}
				if(masPut[i][j]==-2){
					Ny--;
				}
			}
			if(x==Ny && y==Ny){
				return kolPut;
			}
		}
		return 0;
	}
	
	void  zaim(int numPut, int kolPut){
		for(int j = 0; j<=numShag; j++){
			if(masPut[numPut][j]==1){
				masPut[kolPut][j]=1;
			}
			if(masPut[numPut][j]==-1){
				masPut[kolPut][j]=-1;
			}
			if(masPut[numPut][j]==2){
				masPut[kolPut][j]=2;
			}
			if(masPut[numPut][j]==-2){
				masPut[kolPut][j]=-2;
			}
		}
	}
	int poiskputi(){
		numShag=0;
		while(true){
			if(numShag==0){
				pole[oldx/50][oldy/50]=-100;
				kolPut++;
				for (int i = 0; i<38; i++){
					for (int j = 0; j<17; j++){
					if(pole[i][j]==-101){
						pole[i][j]=-2;
					}
						}
							}
			}
			int k = 0;
		for (int i = 0; i<38; i++){
			for (int j = 0; j<17; j++){
				
				if(pole[i][j]==-100){
					k++;
					c=0;
					pole[i][j]=-101;
					if(pole[i+1][j]==-2 || pole[i+1][j]==-3 ){
						pole[i+1][j]=-100;
						c++;
					    masPut[kolPut][numShag]=1;
					    if(pole[i+1][j]==pole[x/50][y/50]){
					    	kShag1 = numShag;
							return kolPut;
						}
					}
					else if(pole[i][j+1]==-2 || pole[i][j+1]==-3){
						
					    pole[i][j+1]=-100;
					    c++;
					    masPut[kolPut][numShag]=2;
					    if(pole[i][j+1]==pole[x/50][y/50]){
					    	kShag1 = numShag;
							return kolPut;
						}
							
					}
					else if(pole[i][j-1]==-2 || pole[i][j-1]==-3){
						
					    pole[i][j-1]=-100;
					    c++;
					    masPut[kolPut][numShag]=-2;
					    if(pole[i][j-1]==pole[x/50][y/50]){
					    	kShag1 = numShag;
							return kolPut;
						}
							
					}
					else if(pole[i-1][j]==-2 || pole[i-1][j]==-3){
						
					    pole[i-1][j]=-100;
					    c++;
					    masPut[kolPut][numShag]=-1;
					    if(pole[i-1][j]==pole[x/50][y/50]){
					    	kShag1 = numShag;
							return kolPut;
						}
							}
					}
					if(c==0){
						pole[i][j]=-102;
						c=-1;
						numShag=0;
						break;
					}
					if(c>0){
						c=-2;
						break;
					}
				}   
			if(c>=0 || c==-2){
				c=-1;
				break;
			}
				}
			
			
		
		numShag++;
		if(k==0){
			c=-1;
			numShag=0;
		}
		}
	}
	
int poiskputi2(){
	numShag=0;
		while(true){
			if(numShag==0){
				pole[oldx/50][oldy/50]=-100;
				kolPut++;
				for (int i = 0; i<38; i++){
					for (int j = 0; j<17; j++){
					if(pole[i][j]==-101){
						pole[i][j]=-2;
					}
						}
							}
			}
			int k = 0;
		for (int i = 0; i<38; i++){
			for (int j = 0; j<17; j++){
				
				if(pole[i][j]==-100){
					k++;
					c=0;
					pole[i][j]=-101;
					if(pole[i-1][j]==-2 || pole[i-1][j]==-3){
						
					    pole[i-1][j]=-100;
					    c++;
					    masPut[kolPut][numShag]=-1;
					    if(pole[i-1][j]==pole[x/50][y/50]){
					    	kShag2 = numShag;
							return kolPut;
						}
							}
					else if(pole[i][j-1]==-2 || pole[i][j-1]==-3){
						
					    pole[i][j-1]=-100;
					    c++;
					    masPut[kolPut][numShag]=-2;
					    if(pole[i][j-1]==pole[x/50][y/50]){
					    	kShag2 = numShag;
							return kolPut;
						}
							
					}
					else if(pole[i][j+1]==-2 || pole[i][j+1]==-3){
						
					    pole[i][j+1]=-100;
					    c++;
					    masPut[kolPut][numShag]=2;
					    if(pole[i][j+1]==pole[x/50][y/50]){
					    	kShag2 = numShag;
							return kolPut;
						}
							
					}
					
					else if(pole[i+1][j]==-2 || pole[i+1][j]==-3 ){
						pole[i+1][j]=-100;
						c++;
					    masPut[kolPut][numShag]=1;
					    if(pole[i+1][j]==pole[x/50][y/50]){
					    	kShag2 = numShag;
							return kolPut;
						}
					}
					}
					if(c==0){
						pole[i][j]=-102;
						c=-1;
						numShag=0;
						break;
					}
					if(c>0){
						c=-2;
						break;
					}
				}   
			if(c>=0 || c==-2){
				c=-1;
				break;
			}
				}
			
			
		
		numShag++;
		if(k==0){
			c=-1;
			numShag=0;
		}
		}
	}
	
void vijnTrue(int x, int y){
	
	vijn[x/50][y/50]=true;
	if((x/50)-1>-1){
		vijn[(x/50)-1][y/50]=true;
		vijn[(x/50)-1][(y/50)+1]=true;
		vijn[(x/50)-1][(y/50)+2]=true;
	}
	if((x/50)-2>-1){
		vijn[(x/50)-2][y/50]=true;
		vijn[(x/50)-2][(y/50)+1]=true;
	}
	if((x/50)-3>-1){
		vijn[(x/50)-3][y/50]=true;
	}
	if((x/50)-1>-1 && (y/50)-1>-1){
		vijn[(x/50)-1][(y/50)-1]=true;
	}
	if((x/50)-2>-1 && (y/50)-1>-1){
		vijn[(x/50)-2][(y/50)-1]=true;
	}
	if((x/50)-1>-1 && (y/50)-2>-1){
		vijn[(x/50)-1][(y/50)-2]=true;
	}
	if((y/50)-1>-1){
		vijn[x/50][(y/50)-1]=true;
		vijn[(x/50)+1][(y/50)-1]=true;
		vijn[(x/50)+2][(y/50)-1]=true;
	}
	if((y/50)-2>-1){
		vijn[x/50][(y/50)-2]=true;
		vijn[(x/50)+1][(y/50)-2]=true;
	}
	if((y/50)-3>-1){
		vijn[x/50][(y/50)-3]=true;
	}
    vijn[(x/50)+1][y/50]=vijn[(x/50)+2][y/50]=vijn[(x/50)+3][y/50]=vijn[x/50][(y/50)+1]=vijn[x/50][(y/50)+2]=vijn[x/50][(y/50)+3]=vijn[(x/50)+1][(y/50)+1]=vijn[(x/50)+1][(y/50)+2]=vijn[(x/50)+2][(y/50)+1]=true;
}
	
	public gamePanel(){
		goldLabel.setFont(font);
		goldLabel.setForeground(goldColor);
		goldLabel.setText(""+hero.getGold());
		goldLabel.setBounds(80, 853, 100, 50);
		add(goldLabel);
		int k = 0;
		int j = 0;
		for(int i = 0; i < 10; i++){
		kolVoiskLabel[k] = new JLabel();
		kolVoiskLabel[k].setFont(font);
		kolVoiskLabel[k].setForeground(Color.BLACK);
		kolVoiskLabel[k].setText(""+KolVoisk[k]);
		kolVoiskLabel[k].setBounds(400+i*77, 911+j*80, 25, 20);
		if(i == 9){
			j++;
			if(j==1){
			i = -1;
			}
		}
		add(kolVoiskLabel[k]);
		if(KolVoisk[k] == 0){
			kolVoiskLabel[k].setVisible(false);
		}
		k++;
		}
		j = 0;
		k = 0;
			JButton portrait = new JButton();
			portrait.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					hero.payGold();
					UpdateGoldLabel(goldLabel);
				}
				
			});
			portrait.setSize(68,50);
			portrait.setLocation(250,870);
			portrait.setBorderPainted(false);
			portrait.setFocusPainted(false);
			portrait.setContentAreaFilled(false);
			add(portrait);
			
		class myMouse implements MouseListener, MouseMotionListener {

			@Override
			public void mouseClicked(MouseEvent me) {
				
				x = me.getX();
				y = me.getY();
				
				System.out.println(x);
				System.out.println(y);
				
				if(y<850){
				if(dvij==false){
					
					if(pole[x/50][y/50]==-1){
						pole[x/50][y/50]=-2;
					
				f1 = poiskputi();
				
				for (int i = 0; i<38; i++){
					for (int j = 0; j<17; j++){
						if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
							pole[i][j]=-2;
						}
						
						}
					}
				numShag=0;
				
				f2 = poiskputi2();
				if(kShag1<=kShag2){
					f=f1;
					numShag=kShag1;
				} else {
					f=f2;
					numShag=kShag2;
				}
				for (int i = 0; i<38; i++){
					for (int j = 0; j<17; j++){
						if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
							pole[i][j]=-2;
						}
						
						}
					}
				pole[x/50][y/50]=-1;
				click = true;
				
					} else if(pole[oldx/50][oldy/50]==-1){
						
							
						
						f1 = poiskputi();
						
						for (int i = 0; i<38; i++){
							for (int j = 0; j<17; j++){
								if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
									pole[i][j]=-2;
								}
								
								}
							}
						numShag=0;
						
						f2 = poiskputi2();
						if(kShag1<=kShag2){
							f=f1;
							numShag=kShag1;
						} else {
							f=f2;
							numShag=kShag2;
						}
						for (int i = 0; i<38; i++){
							for (int j = 0; j<17; j++){
								if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
									pole[i][j]=-2;
								}
								
								}
							}
						pole[oldx/50][oldy/50]=-1;
						click = true;
						
					} else if(pole[x/50][y/50]==-2 || pole[x/50][y/50]==-3){
						f1 = poiskputi();
						
						for (int i = 0; i<38; i++){
							for (int j = 0; j<17; j++){
								if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
									pole[i][j]=-2;
								}
								
								}
							}
						numShag=0;
						
						f2 = poiskputi2();
						if(kShag1<=kShag2){
							f=f1;
							numShag=kShag1;
						} else {
							f=f2;
							numShag=kShag2;
						}
						for (int i = 0; i<38; i++){
							for (int j = 0; j<17; j++){
								if(pole[i][j]==-100 || pole[i][j]==-101 || pole[i][j]==-102 ){
									pole[i][j]=-2;
								}
								
								}
							}
						click = true;
						
					} else {
						click = true;
					}
				}
				}else{
				click = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}

			@Override
			public void mouseExited(MouseEvent me) {
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}

			@Override
			public void mouseDragged(MouseEvent me) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
			
		}
		addMouseListener(new myMouse());
		addMouseMotionListener(new myMouse());
		try {
			fon = ImageIO.read(new File("C:\\GameJava\\grass.png"));
		} catch (IOException e) {
			
		}
		
		try {
			slotVoisk = ImageIO.read(new File("C:\\GameJava\\slotVoisk.png"));
		} catch (IOException e) {
			
		}
		
		try {
			portraitImage1 = ImageIO.read(new File("C:\\GameJava\\port1.png"));
		} catch (IOException e) {
			
		}
		
		try {
			nameHero1 = ImageIO.read(new File("C:\\GameJava\\nameHero1.png"));
		} catch (IOException e) {
			
		}
		
		try {
			nameHero2 = ImageIO.read(new File("C:\\GameJava\\nameHero2.png"));
		} catch (IOException e) {
			
		}
		try {
			portraitImage2 = ImageIO.read(new File("C:\\GameJava\\port2.png"));
		} catch (IOException e) {
			
		}
		try {
			goldStatus = ImageIO.read(new File("C:\\GameJava\\goldStatus.png"));
		} catch (IOException e) {
			
		}
		try {
			goldFon = ImageIO.read(new File("C:\\GameJava\\goldFon.png"));
		} catch (IOException e) {
			
		}
		try {
			castle = ImageIO.read(new File("C:\\GameJava\\castle.png"));
		} catch (IOException e) {
			
		}
		
		try {
			voinImg = ImageIO.read(new File("C:\\GameJava\\voin2.png"));
		} catch (IOException e) {
			
		}
		
		try {
			strelokImg = ImageIO.read(new File("C:\\GameJava\\strelok1.png"));
		} catch (IOException e) {
			
		}
		try {
			tropa1Img = ImageIO.read(new File("C:\\GameJava\\tropaLP1.png"));
		} catch (IOException e) {
			
		}
		try {
			tropa2Img = ImageIO.read(new File("C:\\GameJava\\tropaVN1.png"));
		} catch (IOException e) {
			
		}
		try {
			castleMess = ImageIO.read(new File("C:\\GameJava\\castleMess.png"));
		} catch (IOException e) {
			
		}
		
		try {
			for(int i = 0; i<8; i++){
			spawn[i] = ImageIO.read(new File("C:\\GameJava\\spawn"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		
		try {
			for(int i = 0; i<8; i++){
			walkA[i] = ImageIO.read(new File("C:\\GameJava\\walkA"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		
		try {
			for(int i = 0; i<8; i++){
			walkK[i] = ImageIO.read(new File("C:\\GameJava\\walkR"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		try {
			strelkaPravo = ImageIO.read(new File("C:\\GameJava\\strelkaPravo.png"));
		} catch (IOException e) {
			
		}
		
		try {
			strelkaVverh = ImageIO.read(new File("C:\\GameJava\\strelkaVverh.png"));
		} catch (IOException e) {
			
		}
		try {
			for(int i = 0; i<2; i++){
			voisko[i] = ImageIO.read(new File("C:\\GameJava\\voisko"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		try {
			tree1 = ImageIO.read(new File("C:\\GameJava\\tree1.png"));
		} catch (IOException e) {
			
		}
		try {
			wall = ImageIO.read(new File("C:\\GameJava\\wall.png"));
		} catch (IOException e) {
			
		}
		try {
			rock = ImageIO.read(new File("C:\\GameJava\\rock3.png"));
		} catch (IOException e) {
			
		}
		
		try {
			rockCenter = ImageIO.read(new File("C:\\GameJava\\rockCenter.png"));
		} catch (IOException e) {
			
		}
		
		try {
			ex = ImageIO.read(new File("C:\\GameJava\\ex.png"));
		} catch (IOException e) {
			
		}
		
		try {
			cosmos = ImageIO.read(new File("C:\\GameJava\\tma.png"));
		} catch (IOException e) {
			
		}
		
		try {
			bar = ImageIO.read(new File("C:\\GameJava\\bar0.png"));
		} catch (IOException e) {
			
		}
		try {
			for(int i = 0; i<6; i++){
			treasure[i] = ImageIO.read(new File("C:\\GameJava\\treasure"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		try {
			for(int i = 0; i<6; i++){
			rockTree[i] = ImageIO.read(new File("C:\\GameJava\\rockTree"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		try {
			for(int i = 0; i<4; i++){
			treeS[i] = ImageIO.read(new File("C:\\GameJava\\treeS"+i+".png"));
			}
		} catch (IOException e) {
			
		}
		
		Timer tim = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(click == true){
					
					prob++;
					if(u<=numShag){
						dvij=true;
					if(masPut[f][u]==1){
						oldx++;
						sh++;
						if(sh==50){
							sh=0;
							u++;
						}
						
					}
					if(masPut[f][u]==-1){
						oldx--;
						sh++;
						if(sh==50){
							sh=0;
							u++;
						}
						
					}
					if(masPut[f][u]==2){
						oldy++;
						sh++;
						if(sh==50){
							sh=0;
							u++;
						}
						
					}
					if(masPut[f][u]==-2){
						oldy--;
						sh++;
						if(sh==50){
							sh=0;
							u++;
						}
						
					}
					
					} else {
						click=false;
						for (int i = 0; i<400; i++){
							for (int j = 0; j<100; j++){
						masPut[i][j]=0;
							}
						}
						kolPut=0;
						c=-1;
						f=0;
						u=0;
						numShag=-1;
						kShag1=0;
						kShag2=0;
						Nx = oldx/50;
						Ny = oldy/50;
						dvij=false;
					}
					
				} 
				if(prob==10){
					if(time==7){
						time=-1;
						prob=0;
					}
						time+=1;
						prob=0;
			}
				if(click==false){
					
					time=-1;
				}
				
				repaint();
				revalidate();
				}
			
		});
		tim.start();
		}
	public void paintComponent(Graphics gr) {
		
		
		if(myFrame.nachGame==1 || myFrame.nachGame==-1){
			Game game = new Game();
			game.startgame(myFrame.nachGame);
		}
			
		if(myFrame.nachGame==1 || myFrame.nachGame==-1){
		for (int i = 0; i<=SizeOkno.screenSizeW; i++){
			for (int j = 0; j<=SizeOkno.screenSizeH; j++){
			gr.drawImage(fon, i, j, 100, 100, null);
			j+=99;
			}
			i+=99;
		}
		}
		
		for (int i = 0; i<=1900; i++){
			for (int j = 0; j<=950; j++){
			gr.drawLine(i, j, i+50, j);
			gr.drawLine(i, j, i, j+50);
				j+=49;
			}
			i+=49;
		}
		
		if(drSp==false){
			for (int i = 0; i<42; i++){
				for (int j = 0; j<20; j++){
					vijn[i][j]=false;
					
					}
				}
			
		for (int i = 0; i<41; i++){
			for (int j = 0; j<23; j++){
				pole[i][j]=0;
				
				}
			}
		
		pole[0][0]=-5;
		
		for (int i = 0; i<8; i++){
			for (int j = 6; j<10; j++){
				pole[i][j]=-1;
				vijn[i][j]=true;
				vijn[i][j+1]=true;
				vijn[i][j-1]=true;
				
				}
			}
		
		chislo = (int)(Math.random()*36+1);
		pole[chislo][1]=pole[chislo][2]= 18;
		centerSpawnX[8]=chislo;
		centerSpawnY[8]=1;
		gr.drawImage(tropa2Img, chislo*50, 50, 60, 60,null);
		gr.drawImage(strelkaVverh, chislo*50, 50, 50, 50,null);
		
		chislo = (int)(Math.random()*16);
		pole[37][chislo]= 19;
		centerSpawnX[9]=37;
		centerSpawnY[9]=chislo;
		gr.drawImage(tropa1Img, 1850, chislo*50, 60, 60,null);
		gr.drawImage(strelkaPravo, 1850, chislo*50, 50, 50,null);
		
		chislo=10;
		int spawnNum = 0;
		while(chislo != 18){
			randX = (int)(Math.random()*34);
			randY = (int)(Math.random()*15);
			if(pole[randX][randY]==0 && pole[randX+2][randY+2]==0 && pole[randX+2][randY]==0 && pole[randX][randY+2]==0 && pole[randX+1][randY]==0 && pole[randX+2][randY+1]==0 && pole[randX+5][randY]==0 && pole[randX][randY+5]==0 && pole[randX+5][randY+5]==0 && pole[randX+3][randY+3]==0 && pole[randX+2][randY+3]==0 && pole[randX+3][randY+2]==0 && pole[randX+2][randY+3]==0 && pole[randX+1][randY+3]==0 && pole[randX+3][randY+1]==0 && pole[randX+5][randY+2]==0 && pole[randX+2][randY+5]==0 && pole[randX+4][randY+5]==0 && pole[randX+5][randY+4]==0 && pole[randX+5][randY+1]==0 && pole[randX+5][randY+3]==0 ){
				pole[randX][randY]=pole[randX+1][randY]=pole[randX+2][randY]=pole[randX][randY+1]=pole[randX+1][randY+1]=pole[randX+2][randY+1]=pole[randX][randY+2]=pole[randX+1][randY+2]=pole[randX+2][randY+2]=chislo;
				pole[randX+5][randY]=pole[randX][randY+5]=pole[randX+5][randY+5]=pole[randX+2][randY+5]=pole[randX+5][randY+3]=pole[randX+5][randY+1]=pole[randX+5][randY+2]=pole[randX+5][randY+4]=pole[randX+3][randY+5]=pole[randX+4][randY+5]=pole[randX][randY+4]=pole[randX+3][randY+3]=pole[randX+2][randY+3]=pole[randX+3][randY+2]=pole[randX+2][randY+3]=pole[randX+1][randY+3]=pole[randX+3][randY+1]=-2;
				gr.drawImage(spawn[spawnNum], randX*50, randY*50, 150, 150,null);
				centerSpawnX[spawnNum] = randX+1;
				centerSpawnY[spawnNum] = randY+1;
				spawnNum++;
				
				chislo++;
			}
		}
		for (int i = 0; i<41; i++){
			for (int j = 0; j<23; j++){
				if(pole[i][j]==-2)
				pole[i][j]=0;
				}
			}
		
		chislo=20;
		int trasureNum = 0;
		while(chislo!=26){
			System.out.println("kek10");
			randX = (int)(Math.random()*36+1);
			randY = (int)(Math.random()*16+1);
			if(pole[randX][randY]==0 && pole[randX+1][randY]==0 && pole[randX][randY+1]==0 && pole[randX+1][randY+1]==0 && pole[randX+1][randY-1]==0 && pole[randX][randY-1]==0 && pole[randX-1][randY-1]==0 && pole[randX-1][randY]==0 && pole[randX-1][randY+1]==0){
				pole[randX][randY]=chislo;
				gr.drawImage(treasure[trasureNum], randX*50, randY*50, 50, 50,null);
				centerSpawnX[trasureNum+10] = randX;
				centerSpawnY[trasureNum+10] = randY;
				trasureNum++;
				chislo++;
			}
		}
		
		chislo=9;
		
		for(int i = 0; i<16; i++){
		int trI = 5;
		int trJ = 9;
		chislo++;
		do{
			while(trI !=centerSpawnX[i] ){
				
				gr.drawImage(tropa1Img, trI*50, trJ*50, 60, 60,null);
				pole[trI][trJ]=-2;
			if(trI<centerSpawnX[i]){
				if(pole[trI+1][trJ]==chislo){
					pole[trI+1][trJ]=chislo;
					trI++;
					break;
				}
				if(pole[trI+1][trJ]==0 || pole[trI+1][trJ]==-1 || pole[trI+1][trJ]==-2 || pole[trI+1][trJ]==-3){
				trI++;
				pole[trI][trJ]=-2;
				} else if(pole[trI][trJ+1]==0 || pole[trI][trJ+1]==chislo || pole[trI][trJ+1]==-2 || pole[trI][trJ+1]==-3){
					trJ++;
					pole[trI][trJ]=-2;
				} else if(pole[trI][trJ-2]==0 || pole[trI][trJ-2]==chislo || pole[trI][trJ-2]==-2 || pole[trI][trJ-2]==-3){
					gr.drawImage(tropa2Img, trI*50, (trJ-1)*50, 60, 60,null);
					pole[trI][trJ-1]=-3;
					gr.drawImage(tropa2Img, trI*50, (trJ-2)*50, 60, 60,null);
					pole[trI][trJ-2]=-3;
					trJ-=2;
				}
				else{
					gr.drawImage(tropa1Img, (trI+4)*50, trJ*50, 60, 60,null);
					pole[trI+4][trJ]=-2;
					trI+=4;
					System.out.println("kek1");
				}
				} else if(trI>centerSpawnX[i]){
					if(pole[trI-1][trJ]==chislo ){
						trI--;
						pole[trI][trJ]=chislo;
						break;
					}
					if(pole[trI-1][trJ]==0 || pole[trI-1][trJ]==-1 || pole[trI-1][trJ]==-2 || pole[trI-1][trJ]==-3){
					trI--;
					pole[trI][trJ]=-2;
					} else if(pole[trI][trJ+1]==0 || pole[trI][trJ+1]==chislo || pole[trI][trJ+1]==-2 || pole[trI][trJ+1]==-3){
						trJ++;
						pole[trI][trJ]=-2;
					} else if(pole[trI][trJ-2]==0 || pole[trI][trJ-2]==chislo || pole[trI][trJ-2]==-2 || pole[trI][trJ-2]==-3){
						gr.drawImage(tropa2Img, trI*50, (trJ-1)*50, 60, 60,null);
						pole[trI][trJ-1]=-3;
						gr.drawImage(tropa2Img, trI*50, (trJ-2)*50, 60, 60,null);
						pole[trI][trJ-2]=-3;
						trJ-=2;
					} else{
						System.out.println("kek2");
					}
				}
		}
			while(trJ != centerSpawnY[i]){
				
			gr.drawImage(tropa2Img, trI*50, trJ*50, 60, 60,null);
			pole[trI][trJ]=-3;
			if(trJ<centerSpawnY[i]){
				if(pole[trI][trJ+1]==chislo){
					trJ++;
					pole[trI][trJ]=chislo;
					break;
				}
				else if(pole[trI][trJ+1]==0 || pole[trI][trJ+1]==-1 || pole[trI][trJ+1]==-2 || pole[trI][trJ+1]==-3){
			trJ++;
			pole[trI][trJ]=-2;
				} else if(pole[trI+1][trJ]==0 || pole[trI+1][trJ]==chislo || pole[trI+1][trJ]==-2 || pole[trI+1][trJ]==-3){
					trI++;
					pole[trI][trJ]=-2;
				} else //if(trI-2>-1){
					if(pole[trI-2][trJ]==0 || pole[trI-2][trJ]==chislo || pole[trI-2][trJ]==-2 || pole[trI-2][trJ]==-3){
					gr.drawImage(tropa1Img, (trI-1)*50, trJ*50, 60, 60,null);
					pole[trI-1][trJ]=-2;
					gr.drawImage(tropa1Img, (trI-2)*50, trJ*50, 60, 60,null);
					pole[trI-2][trJ]=-2;
					trI-=2;
				//	}
				} else while(pole[trI][trJ+1]!=0 && pole[trI][trJ+1]!=-1 && pole[trI][trJ+1]!=-2 && pole[trI][trJ+1]!=-3) {
					if(pole[trI-1][trJ]==0 || pole[trI-1][trJ]==chislo || pole[trI-1][trJ]==-2 || pole[trI-1][trJ]==-3){
						gr.drawImage(tropa1Img, (trI-1)*50, trJ*50, 60, 60,null);
						pole[trI-1][trJ]=-2;
						trI-=1;
						System.out.println("kek5");
					} else{
						gr.drawImage(tropa1Img, (trI-1)*50, trJ*50, 60, 60,null);
						trI-=1;
						pole[trI][trJ]=-2;
					}
					System.out.println("kek3");
				}
			} else if(trJ>centerSpawnY[i]){
				if(pole[trI][trJ-1]==chislo ){
					trJ--;
					pole[trI][trJ]=chislo;
					break;
				}
				if(pole[trI][trJ-1]==0 || pole[trI][trJ-1]==-1 || pole[trI][trJ-1]==-2 || pole[trI][trJ-1]==-3){
				trJ--;
				pole[trI][trJ]=-2;
				} else if(pole[trI+1][trJ]==0 || pole[trI+1][trJ]==chislo || pole[trI+1][trJ]==-2 || pole[trI+1][trJ]==-3){
					trI++;
					pole[trI][trJ]=-2;
				} else if(pole[trI-2][trJ]==0 || pole[trI-2][trJ]==chislo || pole[trI-2][trJ]==-2 || pole[trI+-2][trJ]==-3){
					gr.drawImage(tropa1Img, (trI-1)*50, trJ*50, 60, 60,null);
					pole[trI-1][trJ]=-2;
					gr.drawImage(tropa1Img, (trI-2)*50, trJ*50, 60, 60,null);
					pole[trI-2][trJ]=-2;
					trI-=2;
				} else while(pole[trI][trJ-1]!=0 && pole[trI][trJ-1]!=-1 && pole[trI][trJ-1]!=-2 && pole[trI][trJ-1]!=-3) {
					gr.drawImage(tropa1Img, trI*50, trJ*50, 60, 60,null);
					if(pole[trI+1][trJ]==0 || pole[trI+1][trJ]==chislo || pole[trI+1][trJ]==-2 || pole[trI+1][trJ]==-3){
					gr.drawImage(tropa1Img, (trI+1)*50, trJ*50, 60, 60,null);
					pole[trI+1][trJ]=-2;
					trI+=1;
					System.out.println("kek4");
				} else{
					gr.drawImage(tropa1Img, (trI+1)*50, trJ*50, 60, 60,null);
					trI+=1;
					pole[trI][trJ]=-2;
				}
					
				}
			}
		}
			
			System.out.println("kek11"); 
		}
		while(trI != centerSpawnX[i]  || trJ != centerSpawnY[i]);
		}
		drSp=true;
		
		}
		
		chislo=10;
		int spawnNum = 0;
		while(chislo != 18){
			gr.drawImage(spawn[spawnNum], (centerSpawnX[spawnNum]-1)*50, (centerSpawnY[spawnNum]-1)*50, 150, 150,null);
			spawnNum++;
			chislo++;
		}
		
		chislo=20;
		int trasureNum = 0;
		while(chislo!=26){
				gr.drawImage(treasure[trasureNum], centerSpawnX[trasureNum+10]*50, centerSpawnY[trasureNum+10]*50, 50, 50,null);
				trasureNum++;
				chislo++;
			
		}
		
			gr.drawImage(castle, 25, SizeOkno.screenSizeH/2-250, 300, 222,null);
		    
			if (Game.getheroPlay()==1 && myFrame.nachGame==1){
				gr.drawImage(voinImg, 275, 400, 50, 50, null);
				gr.drawImage(portraitImage1, 220, 870, 50, 68, null);
				 voin Mechnik = new voin();
				 Mechnik.armor = 40;
				 Mechnik.damage = 100;
				 Mechnik.hp = 1000;
				 Mechnik.attak_speed = 20;
				 Mechnik.range_attak = 1;
				 Mechnik.sword = 1;
				 hero.gold = 100;
				 Mechnik.createVoisko(KolVoisk);
				vijnTrue(275,400);
				} 
				else if(Game.getheroPlay() == -1 && myFrame.nachGame==-1){
					gr.drawImage(strelokImg, 275, 400, 50, 50, null);
					gr.drawImage(portraitImage2, 220, 870, 50, 68, null);
					strelok luchnik = new strelok();
					 luchnik.armor = 10;
					 luchnik.damage = 60;
					 luchnik.hp = 1000;
					 luchnik.attak_speed = 30;
					 luchnik.range_attak = 8;
					 luchnik.bow = 1;
					 hero.gold = 100;
					 luchnik.createVoisko(KolVoisk);
					vijnTrue(275,400);
				}
		
			
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
					if(pole[i][j]==0 && pole[i][j+1]==0){
						if(pole[i+1][j]==0 && pole[i+1][j+1]==0 && pole[i][j+1]==0 && pole[i][j+2]==0 && pole[i+1][j+2]==0 && pole[i+2][j+2]==0 && pole[i+2][j+1]==0 && pole[i+2][j]==0){
							gr.drawImage(rock,i*50,j*50,100,100, null);
							pole[i][j]=-10;
							pole[i+1][j]=pole[i+1][j+1]=pole[i][j+1]=-11;
							
						}else {
						chislo = (int)(Math.random()*4);
						gr.drawImage(treeS[chislo],i*50,j*50,70,100, null);
						pole[i][j]=chislo-9;
						}
						
						}
					}
				}
			
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
					if(pole[i][j]==-10 && pole[i+2][j]==-10){
						 gr.drawImage(rock,(i+1)*50+15,j*50,70,100, null);
						 gr.drawImage(rockCenter,(i+1)*50,(j*50)+25,100,40, null);
					}
					if(pole[i][j]==-10 && pole[i][j+2]==-10){
						gr.drawImage(rock,i*50,(j+1)*50+15,100,60, null);
						gr.drawImage(rockCenter,i*50+25,(j+1)*50,50,100, null);
					}
					}
				}
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
                        if(pole[i][j]==-10 && pole[i][j+2]==-10 && pole[i+2][j]==-10 && pole[i+2][j+2]==-10){
						
						gr.drawImage(rockCenter,(i+1)*50,(j+1)*50,100,100, null);
					}
					}
				}
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
			if((pole[i][j]==-11 && pole[i][j+1]==0) || (pole[i][j]==10 && pole[i][j+1]==0) || (pole[i][j]==11 && pole[i][j+1]==0) || (pole[i][j]==12 && pole[i][j+1]==0) || (pole[i][j]==13 && pole[i][j+1]==0) || (pole[i][j]==14 && pole[i][j+1]==0) || (pole[i][j]==15 && pole[i][j+1]==0) || (pole[i][j]==16 && pole[i][j+1]==0) || (pole[i][j]==17 && pole[i][j+1]==0)){
				chislo = (int)(Math.random()*4);
				gr.drawImage(treeS[chislo],i*50,j*50,70,100, null);
				pole[i][j]=chislo-9;
			}
				}
			}
			
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
					if(pole[i][j]==-10){
						gr.drawImage(rockTree[chet],i*50,j*50-25,100,100, null);
						chet++;
						if(chet==6){
							chet=0;
						}
					}
					}
				}
			for (int i = 0; i<38; i++){
				for (int j = 0; j<18; j++){
					gr.drawString(pole[i][j]+" ", i*50+25, j*50+25);
					}
				}
		myFrame.nachGame=0;
		
		
		if(click==true || time==-1 ){
			
			for (int i = 0; i<=SizeOkno.screenSizeW; i++){
				for (int j = 0; j<=SizeOkno.screenSizeH; j++){
				gr.drawImage(fon, i, j, 100, 100, null);
				j+=99;
				}
				i+=99;
			}
			
			for(int i = 0; i<38; i++ ){
				for(int j = 0; j<20; j++ ){
					if(pole[i][j]==-2){
				gr.drawImage(tropa1Img, i*50, j*50, 60, 60,null);
					}
					if(pole[i][j]==-3){
						gr.drawImage(tropa2Img, i*50, j*50, 60, 60,null);
					}
					if(pole[i][j]==18){
						gr.drawImage(tropa2Img, i*50, 50, 60, 60,null);
						gr.drawImage(strelkaVverh, i*50, 50, 50, 50,null);
					}
					if(pole[i][j]==19){
						gr.drawImage(tropa1Img, 37*50, j*50, 60, 60,null);
						gr.drawImage(strelkaPravo, 37*50, j*50, 50, 50,null);
					}
				}
		}
			chislo=10;
			 spawnNum = 0;
			while(chislo != 18){
				gr.drawImage(spawn[spawnNum], (centerSpawnX[spawnNum]-1)*50, (centerSpawnY[spawnNum]-1)*50, 150, 150,null);
				spawnNum++;
				chislo++;
			}
			
			chislo=20;
		    trasureNum = 0;
			while(chislo!=26){
					gr.drawImage(treasure[trasureNum], centerSpawnX[trasureNum+10]*50, centerSpawnY[trasureNum+10]*50, 50, 50,null);
					trasureNum++;
					chislo++;
				
			}
			
				if(pole[x/50][y/50]==-2 || pole[x/50][y/50]==-3){
					vijnTrue(oldx,oldy);
					if(Game.getheroPlay()==1){
						if(time==-1){
						gr.drawImage(voinImg, oldx, oldy, 50, 50, null);
						}
						if(time==0){
							gr.drawImage(walkK[0], oldx, oldy, 50, 50, null);
							}
						if(time==1){
							gr.drawImage(walkK[1], oldx, oldy, 50, 50, null);
							}
						if(time==2){
							gr.drawImage(walkK[2], oldx, oldy, 50, 50, null);
							}
						if(time==3){
							gr.drawImage(walkK[3], oldx, oldy, 50, 50, null);
							}
						if(time==4){
							gr.drawImage(walkK[4], oldx, oldy, 50, 50, null);
							}
						if(time==5){
							gr.drawImage(walkK[5], oldx, oldy, 50, 50, null);
							}
						if(time==6){
							gr.drawImage(walkK[6], oldx, oldy, 50, 50, null);
							}
						if(time==7){
							gr.drawImage(walkK[7], oldx, oldy, 50, 50, null);
							}
							} 
							else if (Game.getheroPlay()==-1){
								if(time==-1)
								gr.drawImage(strelokImg, oldx, oldy, 50, 50, null);
								if(time==0){
									gr.drawImage(walkA[0], oldx, oldy, 50, 50, null);
									}
								if(time==1){
									gr.drawImage(walkA[1], oldx, oldy, 50, 50, null);
									}
								if(time==2){
									gr.drawImage(walkA[2], oldx, oldy, 50, 50, null);
									}
								if(time==3){
									gr.drawImage(walkA[3], oldx, oldy, 50, 50, null);
									}
								if(time==4){
									gr.drawImage(walkA[4], oldx, oldy, 50, 50, null);
									}
								if(time==5){
									gr.drawImage(walkA[5], oldx, oldy, 50, 50, null);
									}
								if(time==6){
									gr.drawImage(walkA[6], oldx, oldy, 50, 50, null);
									}
								if(time==7){
									gr.drawImage(walkA[7], oldx, oldy, 50, 50, null);
									}
							}
			
				
				}
				else if(pole[x/50][y/50]==-1){
					vijnTrue(oldx,oldy);
					if(Game.getheroPlay()==1){
						if(time==-1){
						gr.drawImage(voinImg, oldx, oldy, 50, 50, null);
						}
						if(time==0){
							gr.drawImage(walkK[0], oldx, oldy, 50, 50, null);
							}
						if(time==1){
							gr.drawImage(walkK[1], oldx, oldy, 50, 50, null);
							}
						if(time==2){
							gr.drawImage(walkK[2], oldx, oldy, 50, 50, null);
							}
						if(time==3){
							gr.drawImage(walkK[3], oldx, oldy, 50, 50, null);
							}
						if(time==4){
							gr.drawImage(walkK[4], oldx, oldy, 50, 50, null);
							}
						if(time==5){
							gr.drawImage(walkK[5], oldx, oldy, 50, 50, null);
							}
						if(time==6){
							gr.drawImage(walkK[6], oldx, oldy, 50, 50, null);
							}
						if(time==7){
							gr.drawImage(walkK[7], oldx, oldy, 50, 50, null);
							}
							} 
					else if (Game.getheroPlay()==-1){
						if(time==-1)
						gr.drawImage(strelokImg, oldx, oldy, 50, 50, null);
						if(time==0){
							gr.drawImage(walkA[0], oldx, oldy, 50, 50, null);
							}
						if(time==1){
							gr.drawImage(walkA[1], oldx, oldy, 50, 50, null);
							}
						if(time==2){
							gr.drawImage(walkA[2], oldx, oldy, 50, 50, null);
							}
						if(time==3){
							gr.drawImage(walkA[3], oldx, oldy, 50, 50, null);
							}
						if(time==4){
							gr.drawImage(walkA[4], oldx, oldy, 50, 50, null);
							}
						if(time==5){
							gr.drawImage(walkA[5], oldx, oldy, 50, 50, null);
							}
						if(time==6){
							gr.drawImage(walkA[6], oldx, oldy, 50, 50, null);
							}
						if(time==7){
							gr.drawImage(walkA[7], oldx, oldy, 50, 50, null);
							}
					}
					if(click==false){
					gr.drawImage(castleMess, SizeOkno.screenSizeW/2-500, SizeOkno.screenSizeH/2-300, 500, 300, null);
					castleMessVisible = true;
					}
				} else if(pole[x/50][y/50]==-10 || pole[x/50][y/50]==-11 || pole[x/50][y/50]==0 || pole[x/50][y/50]==-6 || pole[x/50][y/50]==-7 || pole[x/50][y/50]==-8 || pole[x/50][y/50]==-9){
					vijnTrue(oldx,oldy);
					if(Game.getheroPlay()==1)
					gr.drawImage(voinImg, oldx, oldy, 50, 50, null);
					if (Game.getheroPlay()==-1)
					gr.drawImage(strelokImg, oldx, oldy, 50, 50, null);
				}
				
				gr.drawImage(castle, 25, SizeOkno.screenSizeH/2-250, 300, 222, null); 
				
				for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
						if(pole[i][j]==-10 ){
							gr.drawImage(rock,i*50,j*50,100,100, null);
							
						}else {
						if(pole[i][j]==-6){
							gr.drawImage(treeS[3],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-7){
							gr.drawImage(treeS[2],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-8){
							gr.drawImage(treeS[1],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-9){
							gr.drawImage(treeS[0],i*50,j*50,70,100, null);
							}
						}
						}
					}
				for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
						if(pole[i][j]==-10 && pole[i+2][j]==-10){
							 gr.drawImage(rock,(i+1)*50+15,j*50,70,100, null);
							 gr.drawImage(rockCenter,(i+1)*50,(j*50)+25,100,40, null);
						}
						if(pole[i][j]==-10 && pole[i][j+2]==-10){
							gr.drawImage(rock,i*50,(j+1)*50+15,100,60, null);
							gr.drawImage(rockCenter,i*50+25,(j+1)*50,50,100, null);
						}
						
						}
					}
				for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
                            if(pole[i][j]==-10 && pole[i][j+2]==-10 && pole[i+2][j]==-10 && pole[i+2][j+2]==-10){
							
							gr.drawImage(rockCenter,(i+1)*50,(j+1)*50,100,100, null);
						}
						}
					}
				for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
						if(pole[i][j]==-6){
							gr.drawImage(treeS[3],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-7){
							gr.drawImage(treeS[2],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-8){
							gr.drawImage(treeS[1],i*50,j*50,70,100, null);
							}
						if(pole[i][j]==-9){
							gr.drawImage(treeS[0],i*50,j*50,70,100, null);
							}
					}
				}
				chet=0;
				for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
						if(pole[i][j]==-10){
							gr.drawImage(rockTree[chet],i*50,j*50-25,100,100, null);
							chet++;
							if(chet==6){
								chet=0;
							}
						}
						}
					}
				gr.drawImage(wall, 0, 17*50,1920,170, null);
				/*	for (int i = 0; i<38; i++){
					for (int j = 0; j<18; j++){
						gr.drawString(pole[i][j]+" ", i*50+25, j*50+25);
						}
					}
				for (int i = 0; i<=1900; i++){
					for (int j = 0; j<=950; j++){
					gr.drawLine(i, j, i+50, j);
					gr.drawLine(i, j, i, j+50);
						j+=49;
					}
					i+=49;
				}*/	
				for (int i = 0; i<42; i++){
					for (int j = 0; j<20; j++){
						if(vijn[i][j]==false){
							gr.drawImage(cosmos, i*50, j*50, 50, 50, null);
						}
						
						}
					}
				for (int i = 0; i<39; i++){
					for (int j = 17; j<21; j++){
						pole[i][j]=-4;
						gr.drawImage(wall, 0, 17*50,1920,170, null);
						}
					}
				
		}	
	
	for (int i = 0; i<42; i++){
		for (int j = 0; j<20; j++){
			if(vijn[i][j]==false){
				gr.drawImage(cosmos, i*50, j*50, 50, 50, null);
			}
			
			}
		}
	if(castleMessVisible==true){
		gr.drawImage(castleMess, SizeOkno.screenSizeW/2-500, SizeOkno.screenSizeH/2-300, 500, 300, null);
	}
	for (int i = 0; i<39; i++){
		for (int j = 17; j<21; j++){
			pole[i][j]=-4;
			gr.drawImage(wall, 0, 17*50,1920,170, null);
			}
		}
	
	gr.drawImage(goldFon, 25, 860,null);
	gr.drawImage(goldStatus, 25, 850, 50, 50, null);
	
		
	if(Game.getheroPlay()==1){
	gr.drawImage(portraitImage1, 250, 870, 68, 50, null);
	gr.drawImage(nameHero1, 233, 922, 100, 40, null);
	
	
	}
	if(Game.getheroPlay()==-1){
	gr.drawImage(portraitImage2, 250, 870, 68, 50, null);
	gr.drawImage(nameHero2, 233, 922, 100, 40, null);
	}
	UpdateGoldLabel(goldLabel);
	
	for(int i =  0; i<10;i++){
		for(int j =  0; j<2;j++){
	gr.drawImage(slotVoisk, 350+i*77, 856+j*80, 75, 75, null);
			}
		}
	
	for(int i = 0; i < 20; i++){
		int j = 0;
		if(KolVoisk[i] > 0){
	UpdateVoiskoLabel(kolVoiskLabel, i);
	gr.drawImage(voisko[i], 355+i*77, 861+j*80, 65, 65, null);
	gr.drawImage(bar, 397+i*77, 909+j*80, 30, 25, null);
	if(i==9){
		j++;
	}
		} else {
			break;
		}
	}
	}
	
}