public class Ticket {
	private int TicketId;
	private String passengername;
	private int age;
	private String from;
	private String to;
	private int seatno;

	public Ticket(int TicketId, String passengername, int age, String from, String to, int seatno) {
		this.TicketId = TicketId;
		this.passengername = passengername;
		this.age = age;
		this.from = from;
		this.to = to;
		this.seatno = seatno;
	}

	public int getTicketId() {
		return TicketId;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public String toCSV() {
		return TicketId + "," + passengername + "," + age + "," + from + "," + to + "," + seatno;
	}

	public static Ticket fromCSV(String line) {
		String[] parts = line.split(",");
		return new Ticket(
				Integer.parseInt(parts[0].trim()),
				parts[1].trim(),
				Integer.parseInt(parts[2].trim()),
				parts[3].trim(),
				parts[4].trim(),
				Integer.parseInt(parts[5].trim()));
	}

	public String toString() {
		return "TicketId:" + TicketId + " Name:" + passengername + " Age:" + age + " From:" + from + " to:" + to
				+ " Seatno:" + seatno;
	}
}