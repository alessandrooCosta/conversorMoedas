public class Moedas {

    private String base_cod;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public Moedas(Moeda moedaRecord) {
        this.base_cod = moedaRecord.base_code();
        this.target_code = moedaRecord.target_code();
        this.conversion_rate = Double.valueOf(moedaRecord.conversion_rate());
        this.conversion_result = Double.valueOf(moedaRecord.conversion_result());
    }

    @Override
    public String toString() {
        return "" +
                "Moeda Base: '" + base_cod + '\'' +
                ", Codigo da moeda convertida: '" + target_code + '\'' +
                ", Valor unitario da moeda: " + conversion_rate +
                ", Valor total convertido: " + conversion_result;
    }
}
