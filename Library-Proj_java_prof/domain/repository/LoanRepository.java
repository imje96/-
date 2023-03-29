package domain.repository;

import java.util.List;
import domain.model.Loan;

public interface LoanRepository {
    void addUser(Loan loan);

    void updateUser(Loan loan);

    void deleteUser(Loan loan);

    List<Loan> findAll();

    Loan findById(int id);

    Loan findByName(String name);
}
