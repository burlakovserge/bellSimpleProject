package ru.bellintegrator.practice.dao.citizenship;

import ru.bellintegrator.practice.model.Citizenship;

public interface CitizenshipDao {
    Citizenship findByCode(String code);
}
