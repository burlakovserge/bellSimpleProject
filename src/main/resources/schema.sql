CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    first_name  VARCHAR(50) NOT NULL    COMMENT 'Имя',
    second_name VARCHAR(50)             COMMENT 'Фамилия',
    middle_name VARCHAR(50)             COMMENT 'Отчество',
    phone VARCHAR(30) COMMENT 'Телефон',
    work_position   VARCHAR(50) NOT NULL    COMMENT 'Должность',
    doc_number    VARCHAR(30) COMMENT 'Номер документа',
    doc_date    DATE COMMENT 'Дата документа',
    doc_code SMALLINT,
    citizenship_code SMALLINT,
    is_identified BIT COMMENT '',
    office_id INTEGER NOT NULL COMMENT 'ID оффиса'
);
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    name    VARCHAR(50) NOT NULL     COMMENT '',
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone VARCHAR(30) COMMENT 'Телефон',
    is_active BIT COMMENT '',
    org_id INTEGER NOT NULL COMMENT 'ID организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organization (
  id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
  name    VARCHAR(50) NOT NULL     COMMENT '',
  full_name    VARCHAR(200) NOT NULL     COMMENT '',
  inn  VARCHAR(20)     NOT NULL         COMMENT '',
  kpp VARCHAR (10) NOT NULL COMMENT '',
  address VARCHAR(50) NOT NULL COMMENT '',
  phone VARCHAR(30) COMMENT '',
  is_active BIT  COMMENT ''
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Citizenship (
   id INTEGER ,
   country VARCHAR(25) NOT NULL ,
   code SMALLINT NOT NULL
);
COMMENT ON TABLE Citizenship IS 'Гражданство';

CREATE TABLE IF NOT EXISTS Document (
   id INTEGER ,
   name VARCHAR(120) NOT NULL,
   code SMALLINT NOT NULL
);
COMMENT ON TABLE Document IS 'Документ удостоверяющий личность';

CREATE TABLE IF NOT EXISTS Person_Document (
    person_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
    document_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор документа',

    PRIMARY KEY (person_id, document_id)
);
COMMENT ON TABLE Person_Document IS 'join-таблица для связи человека и документа';

CREATE TABLE IF NOT EXISTS Person_Citizenship (
    person_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
    citizenship_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор документа',

    PRIMARY KEY (person_id, citizenship_id)
);
COMMENT ON TABLE Person_Citizenship IS 'join-таблица для связи человека и гражданства';

CREATE INDEX IX_Person_Office_Id ON Person (office_id);
ALTER TABLE Person ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_Organization_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX IX_Person_Document_Id ON Person_Document (document_id);
ALTER TABLE Person_Document ADD FOREIGN KEY (document_id) REFERENCES Document(id);

CREATE INDEX IX_Document_Person_Id ON Person_Document (person_id);
ALTER TABLE Person_Document ADD FOREIGN KEY (person_id) REFERENCES Person(id);


CREATE INDEX IX_Person_Citizenship_Id ON Person_Citizenship (citizenship_id);
ALTER TABLE Person_Citizenship ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

CREATE INDEX IX_Citizenship_Person_Id ON Person_Citizenship (person_id);
ALTER TABLE Person_Citizenship ADD FOREIGN KEY (person_id) REFERENCES Person(id);
