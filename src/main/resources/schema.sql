CREATE TABLE IF NOT EXISTS Person (
  id                INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  first_name        VARCHAR(50) NOT NULL    COMMENT 'Имя',
  second_name       VARCHAR(50)             COMMENT 'Фамилия',
  middle_name       VARCHAR(50)             COMMENT 'Отчество',
  phone             VARCHAR(30)             COMMENT 'Телефон',
  work_position     VARCHAR(50) NOT NULL    COMMENT 'Должность',
  citizenship_id    INTEGER     NOT NULL    COMMENT 'ID гражданства',
  document_id       INTEGER     NOT NULL    COMMENT 'ID документа удостоверяющего личность',
  office_id         INTEGER     NOT NULL    COMMENT 'ID оффиса',
  is_identified     BIT
);
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS Office (
  id          INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
  name        VARCHAR(50) NOT NULL,
  address     VARCHAR(50) NOT NULL COMMENT 'Адрес',
  phone       VARCHAR(30)          COMMENT 'Телефон',
  is_active   BIT,
  org_id      INTEGER     NOT NULL COMMENT 'ID организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Organization (
  id        INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
  version   INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
  name      VARCHAR(50)  NOT NULL COMMENT 'Сокращенное название организации',
  full_name VARCHAR(200) NOT NULL COMMENT 'Полное наименование организации, с формой собственности',
  inn       VARCHAR(20)  NOT NULL COMMENT 'ИНН',
  kpp       VARCHAR(10)  NOT NULL COMMENT 'КПП',
  address   VARCHAR(50)  NOT NULL COMMENT 'Юридический адрес',
  phone     VARCHAR(30)           COMMENT 'Телефон',
  is_active BIT                   COMMENT 'Ведет деятельность или нет'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Citizenship (
   id       INTEGER               COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
   country  VARCHAR(25) NOT NULL,
   code     VARCHAR(25) NOT NULL
);
COMMENT ON TABLE Citizenship IS 'Гражданство';

CREATE TABLE IF NOT EXISTS Document (
   id                INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
   number            VARCHAR(30) NOT NULL COMMENT 'Номер документа',
   doc_date          DATE        NOT NULL COMMENT 'Дата документа',
   catalogue_docs_id INTEGER     NOT NULL COMMENT 'ID документа в каталоге документов'
);
COMMENT ON TABLE Document IS 'Документ удостоверяющий личность';

CREATE TABLE IF NOT EXISTS Catalogue_Docs (
   id       INTEGER                 COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
   name     VARCHAR(120) NOT NULL,
   code     VARCHAR(25)  NOT NULL
);
COMMENT ON TABLE Catalogue_Docs IS 'Каталог документов';

CREATE INDEX IX_Person_Office_Id ON Person (office_id);
ALTER TABLE Person ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Person_Document_Id ON Person (document_id);
ALTER TABLE Person ADD FOREIGN KEY (document_id) REFERENCES Document(id);

CREATE INDEX IX_Person_Citizenship_Id ON Person (citizenship_id);
ALTER TABLE Person ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

CREATE INDEX IX_Office_Organization_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX IX_Document_Catalogue_Docs_Id ON Document (catalogue_docs_id);
ALTER TABLE Document ADD FOREIGN KEY (catalogue_docs_id) REFERENCES Catalogue_Docs(id);