int printRank (ArrayList<Integer> currentMarksOfClass, int newStudentMark) {
	int counter=0;
	int prev=-1;
	for(int i=0;i<currentMarksOfClass.size();++i){// {39, 38, 38, 36, 34,31,28}
	    	
	    if(currentMarksOfClass.get(i)>newStudentMark && prev!=currentMarksOfClass.get(i)){
		++counter;
		prev=currentMarksOfClass.get(i);
	    }else if(prev==currentMarksOfClass.get(i)){
		continue;
	    }else{
		break;	   
            }	

	}
	return counter+1;
}

/*
Expected printed output when row-length is passed as “5”:

  000010000 //5->9
  000101000
  001020100 //4->7
  010303010


  0001000 //5->9
  0010100
  0102010 //4->7
  1030301
	

       00100  //3->5
       01010
       10201
*/

int getSizeForArrayForTriangle(int size){
	for(){
}

void printTriangle(int sizee){
	if(size==0) {
		System.out.println("");
		return;
	}
	int size=getSizeForArrayForTriangle(sizee);
	int[] curr=new int[size],next=new int[size];
	for(int i=0;i<size;++i){
		if(i==size/2+1){
			curr[i]=1;
		}
		else{
			curr[i]=0;
		}
	}
	for(int i=2;i<=sizee+1;++i){
		for(int j=0;j<size;++j){
		    if(curr[j]==0){
		       System.out.print(" ");
		    }else{
		       System.out.print(curr[j]);				
		    }
		}
		System.out.println("");
		calculateNextArray(curr,next);
	}
}

void calculateNextArray(int[] curr,int[] next){
	for(int i=0;i<next.length;++i){
		next[i]=(i==0)?0:curr[i-1]+(i==next.length-1)?0:curr[i+1];
	}
	curr=next;
}




