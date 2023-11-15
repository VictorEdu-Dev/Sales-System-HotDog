package listaOpcoes;

public enum OptionProtein {
	ESCOLHER("Selecione", 0f),
	Linguiça("Linguiça", 3.00f),
	Salsicha("Salsicha", 2.00f),
	Bacon("Bacon", 3.50f),
	Frango("Frango", 2.50f);

	private String displayText;
    private float price;

    OptionProtein(String string, float f) {
		this.displayText = string;
		this.price = f;
	}

	public String toString() {
        return displayText;
    }

    public float getPrice() {
        return price;
    }
}
