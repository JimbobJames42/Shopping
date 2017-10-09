package Shopping;

public class Order {
final double tax = .0899;
private int day;
private int month;
private int year;
private int items = 0;
private double total;
private boolean payedFor;

public Order(int d, int m, int y, int t) {
	items++;
	total= t;
	day = d;
	month = m;
	year = y;
	payedFor = false;
}
public void addItem(int t){
	items++;
	total+= t;
}
public double setTotal() {
	total += (total*tax);
	return total;
}
public void removeItem(int t){
	items--;
	total-= t;
}
public void setPayed() {
	payedFor = true;
}
public boolean getPayedFor() {
	return payedFor;
}
public double getTotal() {
	return total;
}
}
