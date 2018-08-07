package check;


public enum PrinterModeEnum{

	CONTINUOUS(1), PEEL(2);

	private int id;

	private PrinterModeEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static PrinterModeEnum get(final String value) {

		if (value == null) {

			throw new IllegalArgumentException("value is null");
		}

		return PrinterModeEnum.valueOf(value.trim().toUpperCase());
	}
	
}
