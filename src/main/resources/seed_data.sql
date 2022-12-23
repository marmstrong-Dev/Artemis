INSERT INTO Keepers (keeper_id, keeper_first_name, keeper_last_name, keeper_phone, keeper_email, keeper_start_date)
VALUES
(nextval('keepers_seq'), 'Jack', 'Morris', '791-512-6695', 'jmorris@address.com', '2022-12-13 16:00:52.444'),
(nextval('keepers_seq'), 'Rebecca', 'James', '847-977-5112', 'rjames@address.com', '2022-12-14 16:00:02.944'),
(nextval('keepers_seq'), 'Natalie', 'Patterson', '554-090-1254', 'npatterson@address.com', '2022-12-10 14:01:02.943'),
(nextval('keepers_seq'), 'Ken', 'Richards', '447-485-6565', 'krichards@address.com', '2022-12-14 16:00:46.529');

INSERT INTO Species (species_id, species_name, species_type, species_binomial, species_genus, species_family)
VALUES
(nextval('species_seq'), 'African Giraffe', 'Mammal', 'Giraffa camelopardalis', 'Giraffa', 'Giraffidae'),
(nextval('species_seq'), 'Tiger Salamander', 'Amphibian', 'Ambystoma tigrinum', 'Ambystoma', 'Ambystomatidae'),
(nextval('species_seq'), 'American Alligator', 'Reptile', 'Alligator mississippiensis', 'Alligator', 'Alligatoridae'),
(nextval('species_seq'), 'Red-Tailed Hawk', 'Bird', 'Buteo jamaicensis', 'Buteo', 'Accipitridae');

INSERT INTO Animals (animal_id, animal_description, animal_name, keeper_id, species_id)
VALUES
(nextval('animals_seq'), 'Long Neck - Ugandan Descent - Captivity Raised', 'Jeffrey', 1, 1),
(nextval('animals_seq'), 'Reticulated - Kenyan Descent - Rehabilitated', 'Sally', 1, 1),
(nextval('animals_seq'), 'Young Male - Southeastern US - Hatched In Captivity', 'Argo', 2, 3),
(nextval('animals_seq'), 'Adult Female - Midwestern US - Captured In The Wild', 'Nova', 2, 3),
(nextval('animals_seq'), 'Adult Male - Injured And Rehabilitated', 'Gomez', 3, 4),
(nextval('animals_seq'), 'Adult Female - Raised In Captivity', 'Chief', 3, 4),
(nextval('animals_seq'), 'Male - Endangered - Captured In South Illinois', 'Cori', 4, 2),
(nextval('animals_seq'), 'Female - Endangered - Hatched In Captivity', 'Jean', 4, 2),
(nextval('animals_seq'), 'Female - Endangered - Rehabilitated', 'Sally', 4, 2),
(nextval('animals_seq'), 'Female - Endangered - Captured In Western Florida', 'Mia', 4, 2);