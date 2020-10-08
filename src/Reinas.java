import java.util.ArrayList;
import java.util.List;

public class Reinas {
public static void main(String[] args) {
	calcularSoluciones(8);
}
public static void probarSoluciones(int n,ArrayList<ArrayList<Integer>> solucionesValidas,ArrayList<Integer> reinas) {
	if(reinas.size()== n && !sonDiagonales(reinas)) {
		for (int i = 0; i < reinas.size(); i++) {
			for (int j = 0; j < reinas.size(); j++) {
				if(reinas.get(i)==j) {
					System.out.print("A");
				}
				else {
					System.out.print("x");
				}
			}
			System.out.println("");
			
		}
		System.out.println("");
		solucionesValidas.add(new ArrayList<>(reinas));
	}
	for(int i=0; i<n;i++) {
		if(!reinas.contains(i)) {
			reinas.add(i);
			probarSoluciones(n, solucionesValidas, reinas);
			reinas.remove(reinas.size()-1);
		}
	}
	
}
public static boolean sonDiagonales(List <Integer> aux) {
	for(int i=0; i<aux.size();i++) {
		int x=aux.get(i),y=i;
		while(x>=0&&y>=0) {
			if(y!=i && aux.get(y)==x) {
				return true;
			}
			x--;
			y--;
		}
		x=aux.get(i);
		y=i;
		while(x>=0&& y<aux.size()) {
			if(y!=i&&aux.get(y)==x) {
				return true;
			}
			x--;
			y++;
		}
		
	}
	
	return false;

}
public static int calcularSoluciones(int n) {
	ArrayList<ArrayList<Integer>> solucionesValidas= new ArrayList<>();
	probarSoluciones(n, solucionesValidas, new ArrayList<Integer>());
	return solucionesValidas.size();
}
}

