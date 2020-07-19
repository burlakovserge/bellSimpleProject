INSERT INTO Organization (id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 'Восток-Сервис-Волгоград', 'Общество с ограниченной ответственностью ''Волгоград-Восток-Сервис'' ',
  '3459063410', '345901001', 'Борьбы ул.,1 А', '8 (8442) 29-04-13', 1),
  (2, 'Тулаев-Парк', 'Общество с ограниченной ответственностью ''Тулаев-Парк'' ',
    '3460057570', '346001001', 'Садовая ул., 29 А', '+7 (8442) 50 - 42 - 13', 1),
    (3, 'ГБОУ СПО ВМТ', 'ГОСУДАРСТВЕННОЕ БЮДЖЕТНОЕ ПРОФЕССИОНАЛЬНОЕ ОБРАЗОВАТЕЛЬНОЕ УЧРЕЖДЕНИЕ ''ВОЛЖСКИЙ МАШИНОСТРОИТЕЛЬНЫЙ ТЕХНИКУМ'' ',
     '3435880067', '343501001', 'Машиностроителей ул., д. 15', '+7 (8443) 38-34-92', 0);

INSERT INTO Office (id, name, address, phone, is_active, org_id)
VALUES (1, 'Магазин-Офис', 'Борьбы ул., 1 А', '8 (8442) 29-04-21', 1, 1),
(2, 'Волжский', 'Профсоюзов бульвар, 2', '+7 (8443) 38‒41‒44', 1, 1),
(3, 'Ворошиловский', 'Социалистическая ул., 26', '+7 (8442) 97‒24‒77', 1, 1),
(4, 'Единственный', 'Садовая ул., 29 А','+7 (8442) 50 - 42 - 13', 1, 2),
(5, 'Учебный', 'Машиностроителей ул., д. 15', '+7 (8443) 38-34-92', 0, 3);

INSERT INTO Catalogue_Docs (id, name, code)
VALUES (1, 'Свидетельство о рождении', 03),
(2, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу', 11),
(3, 'Вид на жительство в Российской Федерации', 12), (4, 'Паспорт гражданина Российской Федерации', 21);

INSERT INTO Document (id, number, doc_date, catalogue_docs_id)
VALUES (1, '1810111222', '2000-01-03', 1), (2, '1870541235', '1998-09-02', 2),
(3, '1812085987', '2005-06-07', 3), (4, '1812555555', '2007-01-03', 4);

INSERT INTO Citizenship (id, country, code) VALUES (1, 'Армения', 051), (2, 'Белоруссия', 112), (3, 'Германия', 276),
(4, 'Израиль', 376), (5, 'Италия', 380), (6, 'Россия', 643), (7, 'Таджикистан', 762), (8, 'Франция', 250);

INSERT INTO Person (id, first_name, second_name, middle_name, phone, work_position,
citizenship_id, document_id, office_id, is_identified)
VALUES (1, 'Пономарев', 'Дмитрий', 'Леонидович', '+79991112323', 'Генеральный директор', 2, 4, 1, true);