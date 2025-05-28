package escola;
public class Data {
    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    public boolean posterior(Data d2){
        if (this.ano>d2.ano){
            return true;
        }else if(this.ano==d2.ano){
            if(this.mes>d2.mes){
                return true;
            }else if(this.mes==d2.mes){
                return this.dia>d2.dia;
            }
        }
        return false;
    }
    
}