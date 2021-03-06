import java.util.ArrayList;//Needed for ArrayList class

public class Player {
	private String name;//玩家姓名
	private int chips; //玩家有的籌碼
	private int bet=0;//玩家此局下注的籌碼
	private ArrayList<Card> oneRoundCard; //此牌局的卡
	public Player(String name, int chips){//Player constructor
		oneRoundCard=new ArrayList<Card>();
		this.name=name;
		this.chips=chips;
	}
	public String get_name(){//name的getter 
		return name;
	}
	public int make_bet(){//下注，回傳預計下注的籌碼
		bet=100;
		if(chips<100)
			{bet=10;}
		if(chips<10)
			{bet=1;}
		if(chips<1)
			{bet=0;}
		return bet;
	}
	public void setOneRoundCard(ArrayList<Card> cards){//設定此牌局所得到的卡 setter
		oneRoundCard=cards;
	}
	public boolean hit_me(){//是否要牌，是回傳true，不再要牌則回傳false 
		int value=getTotalValue();
		if(value<=16){return true;}//低於16點要牌
		return false;
		
	}
	public int getTotalValue(){//回傳此牌局所得的卡點數加總
		int total=0;
		for(int i=0;i<oneRoundCard.size();i++){
			Card oneCard=oneRoundCard.get(i);
			int value=0;
			if(oneCard.getRank()>=10){//計算10、J、Q、K的點數
				value=10;
			}
			if(oneCard.getRank()<10&&oneCard.getRank()>1){//計算2~10的點數
				value=oneCard.getRank();
			}
			if(oneCard.getRank()==1){//計算ACE的點數
				if(total>10){value=1;}
				if(total<=10){value=11;}
			}
			total+=value;
		}
		if(total>21){//ACE的特殊處理
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
	public int get_current_chips(){//回傳玩家現有籌碼
		return chips;
	} 
	public void increase_chips (int diff) {//玩家籌碼變動的setter
		chips+=diff;
	}
	public void say_hello(){//玩家Say Hello 
		System.out.println("Hello, I am " + name + "."); 
		System.out.println("I have " + chips + " chips.");
	}
	
	
	
}

