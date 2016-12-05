import java.util.ArrayList;//Needed for ArrayList class

public class Player {
	private String name;//���a�m�W
	private int chips; //���a�����w�X
	private int bet=0;//���a�����U�`���w�X
	private ArrayList<Card> oneRoundCard; //���P�����d
	public Player(String name, int chips){//Player constructor
		oneRoundCard=new ArrayList<Card>();
		this.name=name;
		this.chips=chips;
	}
	public String get_name(){//name��getter 
		return name;
	}
	public int make_bet(){//�U�`�A�^�ǹw�p�U�`���w�X
		bet=100;
		if(chips<100)
			{bet=10;}
		if(chips<10)
			{bet=1;}
		if(chips<1)
			{bet=0;}
		return bet;
	}
	public void setOneRoundCard(ArrayList<Card> cards){//�]�w���P���ұo�쪺�d setter
		oneRoundCard=cards;
	}
	public boolean hit_me(){//�O�_�n�P�A�O�^��true�A���A�n�P�h�^��false 
		int value=getTotalValue();
		if(value<=16){return true;}//�C��16�I�n�P
		return false;
		
	}
	public int getTotalValue(){//�^�Ǧ��P���ұo���d�I�ƥ[�`
		int total=0;
		for(int i=0;i<oneRoundCard.size();i++){
			Card oneCard=oneRoundCard.get(i);
			int value=0;
			if(oneCard.getRank()>=10){//�p��10�BJ�BQ�BK���I��
				value=10;
			}
			if(oneCard.getRank()<10&&oneCard.getRank()>1){//�p��2~10���I��
				value=oneCard.getRank();
			}
			if(oneCard.getRank()==1){//�p��ACE���I��
				if(total>10){value=1;}
				if(total<=10){value=11;}
			}
			total+=value;
		}
		if(total>21){//ACE���S��B�z
			for(int i=0;i<oneRoundCard.size();i++){
				Card oneCard=oneRoundCard.get(i);
				if(oneCard.getRank()==1){
					total=total-10;
					break;
				}
			}
				
		}
		return total;
	}
	public int get_current_chips(){//�^�Ǫ��a�{���w�X
		return chips;
	} 
	public void increase_chips (int diff) {//���a�w�X�ܰʪ�setter
		chips+=diff;
	}
	public void say_hello(){//���aSay Hello 
		System.out.println("Hello, I am " + name + "."); 
		System.out.println("I have " + chips + " chips.");
	}
	
	
	
}

