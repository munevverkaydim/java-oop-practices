/**
 * Maaş hesaplayabilen sınıflar için bir sözleşme (contract) görevi gören arayüz.
 * Interface içindeki metotlar varsayılan olarak 'public abstract' yapıdadır.
 */
public interface Payable {
    // Maaş hesaplama işlevini zorunlu kılan metot gövdesi.
    double calculateSalary();
}