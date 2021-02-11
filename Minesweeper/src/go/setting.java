package go;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class setting extends JFrame {
	JLabel lblTitle; // 타이틀
	JLabel lblName; // 이름
	JLabel lblNumber; // 번호
	JTextField tfName; // 이름 입력창
	JTextField tfNumber; // 번호 입력창
	JButton btnSave; // 저장 버튼
	JButton btnGo; // 리셋 버튼
	
	public Font font2 = new Font("둥근모꼴", Font.PLAIN, 15);
	
	public int size, mine;
	
	// 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
    public setting() {
    	init();
    	setDisplay();
    	showFrame();
    }
    public void init() {
    	setTitle("새로 띄운 창");
        // 주의, 여기서 setDefaultCloseOperation() 정의를 하지 말아야 한다
        // 정의하게 되면 새 창을 닫으면 모든 창과 프로그램이 동시에 꺼진다
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        
        JLabel NewLabel = new JLabel("사전설정");
        
        lblTitle = new JLabel("사이즈와 지뢰 수를 입력하세요.");
        lblTitle.setFont(font2);
        
		lblName = new JLabel("사이즈 (1~32) ");
		lblName.setFont(font2);
		
		lblNumber = new JLabel("지뢰 수");
		lblNumber.setFont(font2);
		
		tfName = new JTextField(10);
		tfNumber = new JTextField(10);
		
		btnGo = new JButton("Go");
		btnGo.setFont(font2);

		btnGo.addActionListener(event -> {
			size = Integer.parseInt(tfName.getText());
			mine = Integer.parseInt(tfNumber.getText());
			//go 버튼 누를 시 실행됨
			dispose();
		});
		
        setLocationRelativeTo(null);// 프레임을 화면 가운데에 배치

    	
    }
    public int get_size() {
    	return this.size;
    }
    public int get_mine() {
    	return this.mine;
    }
    
    private void setDisplay() {
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblTitle);
		pnlNorth.setBorder(new TitledBorder(""));
		
		JPanel pnlWest = new JPanel(new GridLayout(0,1,0,10));
		pnlWest.add(lblName);
		pnlWest.add(lblNumber);
		pnlWest.setBorder(new TitledBorder(""));
		
		JPanel pnlEast = new JPanel(new GridLayout(0,1,0,10));
		pnlEast.add(tfName);
		pnlEast.add(tfNumber);
		pnlEast.setBorder(new TitledBorder(""));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnGo);
		pnlSouth.setBorder(new TitledBorder(""));
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlWest, BorderLayout.WEST);
		add(pnlEast, BorderLayout.EAST);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void showFrame() {
		setTitle("사전 설정");
		pack();
		setLocationRelativeTo(null);
		setResizable(false); // 창을 고정
		setVisible(true);
		
	}
}