/*
IRepository.java
IRepository interface
Author: Moegamat Zaihd Behardien (219233829)
Date: 23 March 2024
*/
package za.ac.cput.repository;

public interface IRepository <T, ID>
{
    T create(T entity);
    T findById(ID id);
    T update(T entity);
    void delete(T entity);
}
