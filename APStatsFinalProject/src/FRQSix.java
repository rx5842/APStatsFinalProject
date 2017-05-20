

import processing.core.PApplet;






public class FRQSix extends PApplet {

	private boolean manOne=false;
	private boolean manTwo=false;
	private boolean womanOne=false;
	private boolean womanTwo=false;
	private double sitA;
	private double sitB;
	private double sitC;
	private double sitD;
	private double sitE;
	private double sitF;
	private int input=0;
	private int iterations;
	private int runcounter;
	private boolean start=false;
	private int roy,g,biv;
	private int colorCounter=10;

	String text1="";



	public void keyPressed() {
		if((key==ENTER||key==RETURN))  
		{
			start=true;
			iterations=Integer.parseInt(text1);
			runcounter=iterations;
		}

		if(key==DELETE||key==BACKSPACE)
		{
			text1=text1.substring(0, text1.length()-1);
		}

		if(key>=48&&key<=57)
			text1+=key;

	}


	public FRQSix() {

		//input=Integer.parseInt(text1);


		runSketch();
		calcValues();
	}




	public void draw() { 
		background(255); 
		noFill();


		if(colorCounter<=0)
		{
			roy=(int) random(255);
			g=(int) random(255);
			biv=(int) random(255);
			colorCounter=5;
		}
		colorCounter--;


		fill(0);
		if(!start)
		{
			inputPhase();
		}
		if(runcounter>0&&start)
		{
			simulation();
			runcounter--;
		}

		else if(runcounter<=0&&start){
			data();
		}

	}



	public void mousePressed() {

	}


	public void mouseDragged() {


	}

	public void inputPhase()
	{
		textSize(30);
		textAlign(CENTER);
		text("Type out how many trials do you want?", width/2, 50);
		fill(roy,g,biv);
		text("PRESS ENTER TO START", width/2, 390);
		fill(0,0,0);
		text(text1+" trials", width/2, 150);
	}

	public void simulation()
	{
		calcValues();
		textSize(30);
		textAlign(CENTER);
		text("True is treatment, false is control", width/2, 50);
		text("Man One chose   "+manOne, width/2, 80);
		text("Man Two chose   "+manTwo, width/2, 110);
		text("woman One chose   "+womanOne, width/2, 140);
		text("woman Two chose   "+womanTwo, width/2, 170);
		text("The situation is   "+calcSituation(), width/2, 210);

	}

	public void data()
	{
		text("The probality of situationA is  "+sitA/iterations, width/2, 30);
		text("The probality of situationB is  "+sitB/iterations, width/2, 60);
		text("The probality of situationC is  "+sitC/iterations, width/2, 90);
		text("The probality of situationD is  "+sitD/iterations, width/2, 120);
		text("The probality of situationE is  "+sitE/iterations, width/2, 150);
		text("The probality of situationF is  "+sitF/iterations, width/2, 180);
	}

	public void calcValues()
	{
		manOneChoose();
		manTwoChoose();
		womanOneChoose();
		womanTwoChoose();
	}

	public boolean manOneChoose()
	{
		int i=(int) (Math.random()*2);
		if(i==0)
		{
			manOne=true;
		}
		else{
			manOne=false;
		}
		return manOne;
	}

	public boolean manTwoChoose()
	{
		if(true)
		{
			int i=(int) (Math.random()*2);
			if(i<1)
			{
				manTwo=false;
			}
			else
			{
				manTwo=true;
			}
		}



		return manTwo;
	}
	public boolean womanOneChoose()
	{
		if(manOne&&manTwo)
		{
			womanOne=false;
		}
		else if(manOne||manTwo)
		{
			int i=(int) (Math.random()*2);
			if(i<1)
			{
				womanOne=false;
			}
			else
			{
				womanOne=true;
			}
		}
		else if(!manOne&&!manTwo)
		{
			womanOne=true;
		}


		return womanOne;
	}
	public boolean womanTwoChoose()
	{
		if(manOne&&manTwo)
		{
			womanTwo=false;
		}
		else if(!manOne&&!manTwo)
		{
			womanTwo=true;
		}

		else if(womanOne)
		{
			womanTwo=false;
		}
		else if(!womanOne)
		{
			womanTwo=true;
		}


		return womanTwo;
	}

	public char calcSituation()
	{
		char result=' ';
		if(manOne&&manTwo)
		{
			result='A';
			sitA++;
		}
		else if(manOne&&womanOne)
		{
			result='B';
			sitB++;
		}
		else if(manOne&&womanTwo)
		{
			result='C';
			sitC++;
		}
		else if(womanOne&&womanTwo)
		{
			result='D';
			sitD++;
		}
		else if(manTwo&&womanTwo)
		{
			result='E';
			sitE++;
		}
		else if(manTwo&&womanOne)
		{
			result='F';
			sitF++;
		}
		return result;
	}


}











