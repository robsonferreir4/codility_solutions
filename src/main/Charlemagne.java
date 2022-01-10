package main;

public class Charlemagne {

	public static void main(String[] args) {
		int[] A = new int[]{2,2,3,4,3,3,2,2,1,1,2,5};
		int[] B = new int[]{-3, -3};

		
		solution(A);
		solution(B);
//		solution(C);
        
    }

    public static int solution(int[] A) {
        int castles = 0;

        
//        2 2 3 4 3 3 2 2 1 1 2 5

        int inicioTerreno = 0;
        int fimTerreno = 0;
        for(int P=0; P < A.length; P++){
        	
        	if(A[P] < 0) {
        		castles++;
        		break;
        	}
        	
        	if(P==0) { //início
        		continue;
        	}
        	if(A[P-1] == A[P]) { //mesma altura, atualizar fim terreno
        		fimTerreno = P;
        		continue;
        	}
        	
//        	System.out.println("terreno atual:" + A[inicioTerreno]+ " " + A[fimTerreno]);
//        	System.out.println("redores: "+ A[inicioTerreno > 0 ? inicioTerreno-1 : 0] + " e " + A[fimTerreno <= A.length-1 ? fimTerreno+1 : A.length-1]);
        	
        	
        	if(inicioTerreno == 0 && A[fimTerreno] != A[P]) { //se for no início e mudar de terreno então constrói e atualiza o atual
        		castles++;
        		inicioTerreno = P;
        		fimTerreno = P;
        		continue;
        	
        	}
        	
        	if(fimTerreno+1 == A.length-1 && A[inicioTerreno] != A[P]) { //chegou no fim, se o anterior for maior, constrói
        		castles++;
        	}
        
        	if(fimTerreno < A.length-1 && A[inicioTerreno-1] != A[fimTerreno+1]) {  //se ao redor for de tamanhos diferentes então atualiza terreno e continua
        		inicioTerreno=P;
        		fimTerreno=P;
        		continue;
        	}
        	
        	if(fimTerreno < A.length-1 && A[inicioTerreno-1] == A[fimTerreno+1]) {
        		castles++;
        		inicioTerreno = P;
        		fimTerreno = P;
        		continue;
        	}
        	
            
        }
        System.out.println(castles);
        return castles;
    }
}
