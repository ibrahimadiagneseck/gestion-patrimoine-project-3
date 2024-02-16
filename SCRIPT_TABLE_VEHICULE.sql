
-------------------------------------------------------------------------------------------------------------------


SELECT * FROM information_schema.tables WHERE table_type = 'BASE TABLE';


-- Drop foreign key constraints referencing the tables to be deleted
ALTER TABLE prestataires_secteur DROP CONSTRAINT IF EXISTS FK_prestataires_secteur_secteur_activite;
ALTER TABLE prestataires_secteur DROP CONSTRAINT IF EXISTS FK_prestataires_secteur_prestataires;

ALTER TABLE bordereau_livraison DROP CONSTRAINT IF EXISTS FK_bordereau_livraison_agent;
ALTER TABLE bordereau_livraison DROP CONSTRAINT IF EXISTS FK_bordereau_livraison_prestataires;
ALTER TABLE bordereau_livraison DROP CONSTRAINT IF EXISTS FK_bordereau_livraison_sections;

ALTER TABLE bon_entree DROP CONSTRAINT IF EXISTS FK_bon_entree_bordereau_livraison;

ALTER TABLE article_bon_entree DROP CONSTRAINT IF EXISTS FK_article_bon_entree_agent;
ALTER TABLE article_bon_entree DROP CONSTRAINT IF EXISTS FK_article_bon_entree_type_objet;
ALTER TABLE article_bon_entree DROP CONSTRAINT IF EXISTS FK_article_bon_entree_bon_entree;
ALTER TABLE article_bon_entree DROP CONSTRAINT IF EXISTS FK_article_bon_entree_lieu_stockage_vehicule;


ALTER TABLE dotation_vehicule DROP CONSTRAINT IF EXISTS FK_dotation_vehicule_vehicule;
ALTER TABLE dotation_vehicule DROP CONSTRAINT IF EXISTS FK_dotation_vehicule_bon_de_sortie;
ALTER TABLE dotation_vehicule DROP CONSTRAINT IF EXISTS FK_dotation_vehicule_agent;


ALTER TABLE dotation_vehicule_vehicule DROP CONSTRAINT IF EXISTS FK_dotation_vehicule_vehicule_vehicule;
ALTER TABLE dotation_vehicule_vehicule DROP CONSTRAINT IF EXISTS FK_dotation_vehicule_vehicule_dotation_vehicule;



ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_pays;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_article_bon_entree;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_type_vehicule;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_type_energie;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_marque_vehicule;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_etat_vehicule;
ALTER TABLE vehicule DROP CONSTRAINT IF EXISTS FK_vehicule_unite_douaniere;


ALTER TABLE agent DROP CONSTRAINT IF EXISTS FK_agent_fonction_agent;
ALTER TABLE agent DROP CONSTRAINT IF EXISTS FK_agent_unite_douaniere;
ALTER TABLE agent DROP CONSTRAINT IF EXISTS FK_agent_corps_agent;

ALTER TABLE unite_douaniere DROP CONSTRAINT IF EXISTS FK_unite_douaniere_type_unite_douaniere;

ALTER TABLE sections DROP CONSTRAINT IF EXISTS FK_section_unite_douaniere;

-- Drop the tables with CASCADE option
DROP TABLE IF EXISTS vehicule;
DROP TABLE IF EXISTS pays;
DROP TABLE IF EXISTS article_bon_entree;
DROP TABLE IF EXISTS bon_entree;
DROP TABLE IF EXISTS bordereau_livraison;
DROP TABLE IF EXISTS agent;
DROP TABLE IF EXISTS type_objet;
DROP TABLE IF EXISTS prestataires_secteur;
DROP TABLE IF EXISTS secteur_activite;
DROP TABLE IF EXISTS prestataires;
DROP TABLE IF EXISTS type_vehicule;
DROP TABLE IF EXISTS type_energie;
DROP TABLE IF EXISTS marque_vehicule;
DROP TABLE IF EXISTS etat_vehicule;
DROP TABLE IF EXISTS unite_douaniere;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS type_unite_douaniere;
DROP TABLE IF EXISTS corps_agent;
DROP TABLE IF EXISTS fonction_agent;
DROP TABLE IF EXISTS lieu_stockage_vehicule;
DROP TABLE IF EXISTS bon_de_sortie;
DROP TABLE IF EXISTS dotation_vehicule;
DROP TABLE IF EXISTS dotation_vehicule_vehicule;








----------------------------------------------------------------------------------------------------



CREATE TABLE fonction_agent (
    code_fonction_agent VARCHAR(10),
    libelle_fonction_agent VARCHAR(100),
    PRIMARY KEY (code_fonction_agent)
);

CREATE TABLE corps_agent (
    code_corps_agent VARCHAR(3),
    libelle_corps_agent VARCHAR(100),
    PRIMARY KEY (code_corps_agent)
);

CREATE TABLE type_unite_douaniere (
    code_type_unite_douaniere VARCHAR(5),
    libelle_type_unite_douaniere VARCHAR(100),
    PRIMARY KEY (code_type_unite_douaniere)
);

CREATE TABLE marque_vehicule (
    code_marque VARCHAR(25),
    libelle_marque VARCHAR(100),
    PRIMARY KEY (code_marque)
);

CREATE TABLE etat_vehicule (
    code_etat VARCHAR(10),
    libelle_etat VARCHAR(10),
    PRIMARY KEY (code_etat)
);

CREATE TABLE type_vehicule (
    code_type_vehicule VARCHAR(25),
    libelle_type_vehicule VARCHAR(100),
    PRIMARY KEY (code_type_vehicule)
);

CREATE TABLE type_energie (
    code_type_energie VARCHAR(20),
    libelle_type_energie VARCHAR(20),
    PRIMARY KEY (code_type_energie)
);

CREATE TABLE prestataires (
    ninea VARCHAR(20),
    raison_sociale VARCHAR(512),
    numero_telephone INT,
    adresse_email  VARCHAR(100),
    adresse VARCHAR(512),
    PRIMARY KEY (ninea)
);

CREATE TABLE secteur_activite (
    code_secteur_activite VARCHAR(10),
    libelle_secteur_activite VARCHAR(255),
    PRIMARY KEY (code_secteur_activite)
);

CREATE TABLE prestataires_secteur (
    ninea VARCHAR(20),
    code_secteur_activite VARCHAR(10),
    PRIMARY KEY (ninea, code_secteur_activite),
    CONSTRAINT FK_prestataires_secteur_prestataires FOREIGN KEY (ninea) REFERENCES prestataires(ninea),
    CONSTRAINT FK_prestataires_secteur_secteur_activite FOREIGN KEY (code_secteur_activite) REFERENCES secteur_activite(code_secteur_activite)
);


CREATE TABLE sections (
    code_section VARCHAR(3),
    libelle_section VARCHAR(100),
    -- code_unite_douaniere VARCHAR(3),
    PRIMARY KEY (code_section)
    -- CONSTRAINT FK_section_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere)
);



CREATE TABLE unite_douaniere (
    code_unite_douaniere VARCHAR(3),
    nom_unite_douaniere VARCHAR(255),
    effectif_unite_douaniere INT,
    nombre_arme INT,
    nombre_automobile INT,
    nombre_materiel INT,
    code_type_unite_douaniere VARCHAR(5),
    PRIMARY KEY (code_unite_douaniere),
    CONSTRAINT FK_unite_douaniere_type_unite_douaniere FOREIGN KEY (code_type_unite_douaniere) REFERENCES type_unite_douaniere(code_type_unite_douaniere)
);


CREATE TABLE unite_douaniere_sections (
    code_unite_douaniere VARCHAR(3),
    code_section VARCHAR(3),
    PRIMARY KEY (code_unite_douaniere, code_section),
    CONSTRAINT FK_unite_douaniere_sections_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_unite_douaniere_sections_sections FOREIGN KEY (code_section) REFERENCES sections(code_section)
);


CREATE TABLE type_objet (
    code_type_objet VARCHAR(5),
    libelle_type_objet VARCHAR(100),
    code_section VARCHAR(3),
    PRIMARY KEY (code_type_objet),
    CONSTRAINT FK_type_objet_sections FOREIGN KEY (code_section) REFERENCES sections(code_section)
);



CREATE TABLE agent (
    matricule_agent VARCHAR(7),
    code_agent VARCHAR(5) UNIQUE,
    nom_agent VARCHAR(100),
    prenom_agent VARCHAR(255),
    numero_telephone_agent INT,
    code_fonction_agent VARCHAR(10),
    code_unite_douaniere VARCHAR(3),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (matricule_agent, code_corps_agent),
    CONSTRAINT FK_agent_fonction_agent FOREIGN KEY (code_fonction_agent) REFERENCES fonction_agent(code_fonction_agent),
    CONSTRAINT FK_agent_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_agent_corps_agent FOREIGN KEY (code_corps_agent) REFERENCES corps_agent(code_corps_agent)
);  


CREATE TABLE bordereau_livraison ( -- exemple : BLSA202311121243214 (SA+heure en Timestamp)
    identifiant_b_l VARCHAR(25),
    numero_b_l VARCHAR(100) UNIQUE,
    description_b_l VARCHAR(512),
    lieu_de_livraison VARCHAR(255),
    date_b_l DATE,
    conformite_b_l VARCHAR(3),
    representant_prestataire VARCHAR(255),
    code_section VARCHAR(3),
    ninea VARCHAR(20),
    matricule_agent VARCHAR(7),
    date_enregistrement Timestamp(6),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_l),
    CONSTRAINT FK_bordereau_livraison_sections FOREIGN KEY (code_section) REFERENCES sections(code_section),
    CONSTRAINT FK_bordereau_livraison_prestataires FOREIGN KEY (ninea) REFERENCES prestataires(ninea),
    CONSTRAINT FK_bordereau_livraison_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);


CREATE TABLE bon_entree ( -- exemple : BESG202311121243214 (SG+heure en Timestamp)
    identifiant_b_e VARCHAR(25),
    numero_b_e VARCHAR(100),
    libelle_bon_entree VARCHAR(255),
    date_bon_entree DATE,
    observation_bon_entree VARCHAR(255),
    identifiant_b_l VARCHAR(25),
    PRIMARY KEY (identifiant_b_e),
    CONSTRAINT FK_bon_entree_bordereau_livraison FOREIGN KEY (identifiant_b_l) REFERENCES bordereau_livraison(identifiant_b_l)
);


CREATE TABLE article_bon_entree (

    identifiant_b_e VARCHAR(25),
    code_article_bon_entree VARCHAR(25),
    code_lieu_vh VARCHAR,
    code_type_objet VARCHAR(5),
    libelle_article_bon_entree VARCHAR(255),
    quantite_entree INT,
    date_enregistrement Timestamp(6),
    matricule_agent VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_e, code_article_bon_entree),
    CONSTRAINT FK_article_bon_entree_bon_entree FOREIGN KEY (identifiant_b_e) REFERENCES bon_entree(identifiant_b_e),
    CONSTRAINT FK_article_bon_entree_type_objet FOREIGN KEY (code_type_objet) REFERENCES type_objet(code_type_objet),
    CONSTRAINT FK_article_bon_entree_lieu_stockage_vehicule FOREIGN KEY (code_lieu_vh) REFERENCES lieu_stockage_vehicule(code_lieu_vh),
    CONSTRAINT FK_article_bon_entree_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);



CREATE TABLE lieu_stockage_vehicule (

    code_lieu_vh VARCHAR(3),
    libellle_lieu_vh VARCHAR(100),
    nombre_limite_stockage_vh INT,
    PRIMARY KEY (code_lieu_vh),
   
);


CREATE TABLE pays (
    code_pays VARCHAR(3),
    libelle_pays VARCHAR(100),
    PRIMARY KEY (code_pays)
);


CREATE TABLE vehicule (
    numero_serie VARCHAR(30),
    numero_immatriculation VARCHAR(20),
    identifiant_b_e VARCHAR(25),
    code_article_bon_entree VARCHAR(25),
    modele VARCHAR(50),
    code_etat VARCHAR(10),
    code_type_energie VARCHAR(20),
    code_pays VARCHAR(3),
    numero_carte_grise VARCHAR(30),
    date_mise_en_circulation DATE,
    code_type_vehicule VARCHAR(25),
    code_marque VARCHAR(25),
    PRIMARY KEY (numero_serie),
    CONSTRAINT FK_vehicule_pays FOREIGN KEY (code_pays) REFERENCES pays(code_pays),
    CONSTRAINT FK_vehicule_article_bon_entree FOREIGN KEY (identifiant_b_e, code_article_bon_entree) REFERENCES article_bon_entree(identifiant_b_e, code_article_bon_entree),
    CONSTRAINT FK_vehicule_type_vehicule FOREIGN KEY (code_type_vehicule) REFERENCES type_vehicule(code_type_vehicule),
    CONSTRAINT FK_vehicule_type_energie FOREIGN KEY (code_type_energie) REFERENCES type_energie(code_type_energie),
    CONSTRAINT FK_vehicule_marque_vehicule FOREIGN KEY (code_marque) REFERENCES marque_vehicule(code_marque),
    CONSTRAINT FK_vehicule_etat_vehicule FOREIGN KEY (code_etat) REFERENCES etat_vehicule(code_etat)
    
);


------------------------------------------------------------------------------------------------------------

CREATE TABLE  bon_pour  (
    identifiant_b_p  VARCHAR(25), -- exemple : BPSG202311121243214 (SG+heure en timestamp)
    numero_courriel_origine INT,
    date_courriel_origine DATE,
    etat_b_p  VARCHAR(10),
    object_courriel_origine VARCHAR(255),
    description_b_p  VARCHAR(100), 

    numero_arrive_d_l_f INT,
    date_arrive_d_l_f DATE,
    observation_d_l_f  VARCHAR(255), 

    numero_arrive_b_l_m INT,
    date_arrive_b_l_m DATE,
    observation_b_l_m  VARCHAR(255), 

    numero_arrive_section INT,
    date_arrive_section DATE,
    observation_section  VARCHAR(255), 

    code_unite_douaniere VARCHAR(3),
    code_section VARCHAR(3),
    date_enregistrement  Timestamp,
    matricule_agent  VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_p),
    CONSTRAINT FK_bon_pour_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_bon_de_sortie_sections FOREIGN KEY (code_section) REFERENCES sections(code_section),
    CONSTRAINT FK_bon_de_sortie_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
    
);



CREATE TABLE  article_bon_pour  (
    identifiant_b_p VARCHAR(25), 
    code_article_bon_pour VARCHAR(25),
    libelle_article_bon_pour VARCHAR(100), 
    quantite_demandee INT,
    code_type_objet VARCHAR(5),
    matricule_agent  VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_p, code_article_bon_pour),
    CONSTRAINT FK_article_bon_pour_bon_pour FOREIGN KEY (identifiant_b_p) REFERENCES bon_pour(identifiant_b_p),
    CONSTRAINT FK_article_bon_pour_type_objet FOREIGN KEY (code_type_objet) REFERENCES type_objet(code_type_objet),   
    CONSTRAINT FK_article_bon_pour_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);



à modifier dans la base de donné: bon_de_sortie, article_bon_sortie

CREATE TABLE  bon_de_sortie  (
    identifiant_b_s  VARCHAR(25), -- exemple : BSSG202311121243214 (SG+heure en timestamp)
    numero_b_s  VARCHAR(100), 
    description_b_s VARCHAR(255),
    date_b_s DATE,
    identifiant_b_p VARCHAR(25), 
    matricule_agent  VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_s),
    CONSTRAINT FK_bon_de_sortie_bon_pour FOREIGN KEY (identifiant_b_p) REFERENCES bon_pour(identifiant_b_p),
    CONSTRAINT FK_bon_de_sortie_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);


CREATE TABLE  article_bon_sortie  (
    identifiant_b_s VARCHAR(25), 
    code_article_bon_sortie VARCHAR(25),
    libelle_article_bon_sortie VARCHAR(100), 
    quantite_accordee INT,
    date_article_bon_sortie DATE,
    matricule_agent  VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_s, code_article_bon_sortie),
    CONSTRAINT FK_article_bon_sortie_bon_de_sortie FOREIGN KEY (identifiant_b_s) REFERENCES bon_de_sortie(identifiant_b_s),
    CONSTRAINT FK_article_bon_sortie_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);



CREATE TABLE  dotation_vehicule (
    identifiant_d_v VARCHAR(25),-- exemple : DVSG202311121243214 (SG+heure en timestamp)
    date_dotation DATE,
    identifiant_b_s VARCHAR(25), 
    code_article_bon_sortie VARCHAR(25),
    matricule_agent  VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_d_v),
   
    CONSTRAINT FK_dotation_vehicule_article_bon_sortie FOREIGN KEY (identifiant_b_s, code_article_bon_sortie) REFERENCES article_bon_sortie(identifiant_b_s, code_article_bon_sortie),
    CONSTRAINT FK_dotation_vehicule_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);

CREATE TABLE  dotation_vehicule_vehicule (

    numero_serie VARCHAR(30),
    identifiant_d_v VARCHAR(25),
   

    PRIMARY KEY (numero_serie,  identifiant_d_v),
    CONSTRAINT FK_vehicule_dotation_vehicule_vehicule FOREIGN KEY (numero_serie) REFERENCES vehicule(numero_serie),
    CONSTRAINT FK_vehicule_dotation_vehicule_dotation_vehicule FOREIGN KEY ( identifiant_d_v) REFERENCES dotation_vehicule ( identifiant_d_v)
    
);





----------------------------------------------------------------------------------------------------


INSERT INTO secteur_activite (code_secteur_activite, libelle_secteur_activite)
VALUES 
    ('IT', 'Technologies de l''information'),
    ('Finance', 'Services financiers'),
    ('Sante', 'Soins de santé'),
    ('Fabrique', 'Fabrication'),
    ('Education', 'Éducation'),
    ('Hotellerie', 'Hôtellerie et restauration'),
    ('Energie', 'Énergie'),
    ('Menuisier', 'Menuisier');



INSERT INTO prestataires (ninea, raison_sociale, numero_telephone, adresse_email, adresse)
VALUES 
    ('005177614', 'cabinet alpha de consultance et de genie-civil-sarl', 123456789, 'email1@example.com', 'Address 1'),
    ('005174222', 'transfert des technologies-sarl', 987654321, 'email2@example.com', 'Address 2'),
    ('005192373', 'entreprise senegalaise de prefabrication-sarl', 555555555, 'email3@example.com', 'Address 3');


INSERT INTO prestataires_secteur (ninea, code_secteur_activite)
VALUES 
    ('005177614', 'IT'),
    ('005174222', 'Finance'),
    ('005192373', 'Sante');


INSERT INTO type_unite_douaniere (code_type_unite_douaniere, libelle_type_unite_douaniere)
VALUES ('BUR', 'BUREAU CENTRAL'),
       ('BRI', 'BRIGADE MOBILE');


INSERT INTO sections (code_section, libelle_section)
VALUES 
    ('SA', 'SECTION ARMEMENT'),
    ('SM', 'SECTION MATERIEL'),
    ('SG', 'SECTION GARAGE');


INSERT INTO unite_douaniere (code_unite_douaniere, nom_unite_douaniere, effectif_unite_douaniere, nombre_arme, nombre_automobile, nombre_materiel, code_type_unite_douaniere)
VALUES 
    ('06K', 'BUREAU DE LA LOGISTIQUE ET DE LA MAINTENANCE', 10, 3, 5, 20, 'BUR'),
    ('06Z', 'BUREAU DE LA PROGRAMMATION ET DES FINANCES', 10, 3, 5, 20, 'BUR');


INSERT INTO unite_douaniere_sections (code_unite_douaniere, code_section)
VALUES 
    ('06K', 'SA'),
    ('06K', 'SM'),
    ('06K', 'SG'),
    ('06Z', 'SA'),
    ('06Z', 'SM'),
    ('06Z', 'SG');


INSERT INTO type_objet (code_type_objet, libelle_type_objet, code_section)
VALUES 
    ('ARMES', 'ARMES ET MUNITIONS', 'SA'),
    ('VEHIC', 'VEHICULES ET MATERIELS ROULANTS', 'SG'),
    ('MATER', 'MATERIELS', 'SM');


INSERT INTO fonction_agent (code_fonction_agent, libelle_fonction_agent)
VALUES ('FCT1', 'Fonction 1'),
       ('FCT2', 'Fonction 2'),
       ('FCT3', 'Fonction 3');



INSERT INTO corps_agent (code_corps_agent, libelle_corps_agent)
VALUES ('CP1', 'Corps 1'),
       ('CP2', 'Corps 2'),
       ('CP3', 'Corps 3');


INSERT INTO agent (matricule_agent, code_agent, nom_agent, prenom_agent, numero_telephone_agent, code_fonction_agent, code_unite_douaniere, code_corps_agent)
VALUES 
    ('MAT001', 'AGT01', 'Nom Agent 1', 'Prenom Agent 1', 123456789, 'FCT1', '06K', 'CP1'),
    ('MAT002', 'AGT02', 'Nom Agent 2', 'Prenom Agent 2', 987654321, 'FCT2', '06Z', 'CP2'),
    ('MAT003', 'AGT03', 'Nom Agent 3', 'Prenom Agent 3', 555555555, 'FCT3', '06K', 'CP3');


INSERT INTO bordereau_livraison (identifiant_b_l, numero_b_l, description_b_l, lieu_de_livraison, date_b_l, conformite_b_l, representant_prestataire, code_section, ninea, matricule_agent, date_enregistrement, code_corps_agent)
VALUES 
    ('BLSA202312011043210', '001', 'Description BL 1', 'Lieu 1', '2023-12-01', 'OUI', 'Livreur 1', 'SA', '005177614', 'MAT001', CURRENT_TIMESTAMP, 'CP1'),
    ('BLSM202312021143211', '002', 'Description BL 2', 'Lieu 2', '2023-12-02', 'OUI', 'Livreur 2', 'SM', '005174222', 'MAT002', CURRENT_TIMESTAMP, 'CP2'),
    ('BLSG202312031243213', '003', 'Description BL 3', 'Lieu 3', '2023-12-03', 'NON', 'Livreur 3', 'SG', '005192373', 'MAT003', CURRENT_TIMESTAMP, 'CP3');


INSERT INTO bon_entree (identifiant_b_e, numero_b_e, libelle_bon_entree, date_bon_entree, observation_bon_entree, identifiant_b_l)
VALUES 
    ('BESA202312011043210', '001', 'Libelle BE 1', '2023-12-01', 'Observation 1', 'BLSA202312011043210'),
    ('BESM202312021143211', '002', 'Libelle BE 2', '2023-12-02', 'Observation 2', 'BLSM202312021143211'),
    ('BESG202312031243213', '003', 'Libelle BE 3', '2023-12-03', 'Observation 3', 'BLSG202312031243213');


-- Insertion des données dans la table article_bon_entree
--INSERT INTO article_bon_entree (identifiant_b_e, code_article_bon_entree, code_type_objet, libelle_article_bon_entree, quantite_entree, date_enregistrement, matricule_agent, code_corps_agent)
--VALUES 
   -- ('BESA202312011043210', 'Article 1', 'ARMES', 'Jeep-toyota corolla-155555', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1'),
    --('BESM202312021143211', 'Article 1', 'VEHIC', 'Ford-honda civic-222222', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    --('BESM202312021143211', 'Article 2', 'VEHIC', 'Chevrolet silverado-volkswagen jetta-777777', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    --('BESG202312031243213', 'Article 1', 'ARMES', 'Toyota tacoma-hyundai elantra-888888', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3');



INSERT INTO pays (code_pays, libelle_pays)
VALUES 
('AF', 'Afghanistan'),
('ZA', 'Afrique du Sud'),
('AX', 'Åland, Îles'),
('AL', 'Albanie'),
('DZ', 'Algérie'),
('DE', 'Allemagne'),
('DD', 'Allemagne de l''EST'),
('AD', 'Andorre'),
('AO', 'Angola'),
('AI', 'Anguilla'),
('AQ', 'Antarctique'),
('AG', 'Antigua et Barbuda'),
('AN', 'Antilles néerlandaises'),
('SA', 'Arabie Saoudite'),
('AR', 'Argentine'),
('AM', 'Arménie'),
('AW', 'Aruba'),
('AU', 'Australie'),
('AT', 'Autriche'),
('AZ', 'Azerbaïdjan'),
('BS', 'Bahamas'),
('BH', 'Bahrein'),
('BD', 'Bangladesh'),
('BB', 'Barbade'),
('BY', 'Bélarus'),
('BE', 'Belgique'),
('BZ', 'Bélize'),
('BJ', 'Bénin'),
('BM', 'Bermudes'),
('BT', 'Bhoutan'),
('BO', 'Bolivie (État plurinational de)'),
('BQ', 'Bonaire, Saint-Eustache et Saba'),
('BA', 'Bosnie-Herzégovine'),
('BW', 'Botswana'),
('BV', 'Bouvet, Ile'),
('BR', 'Brésil'),
('BN', 'Brunéi Darussalam'),
('BG', 'Bulgarie'),
('BF', 'Burkina Faso'),
('BI', 'Burundi'),
('CV', 'Cabo Verde'),
('KY', 'Caïmans, Iles'),
('KH', 'Cambodge'),
('CM', 'Cameroun'),
('CA', 'Canada'),
('CL', 'Chili'),
('CN', 'Chine'),
('CX', 'Christmas, île'),
('CY', 'Chypre'),
('CC', 'Cocos/Keeling (Îles)'),
('CO', 'Colombie'),
('KM', 'Comores'),
('CG', 'Congo'),
('CD', 'Congo, République démocratique du'),
('CK', 'Cook, Iles'),
('KR', 'Corée, République de'),
('KP', 'Corée, République populaire démocratique de'),
('CR', 'Costa Rica'),
('CI', 'Côte d''Ivoire'),
('HR', 'Croatie'),
('CU', 'Cuba'),
('CW', 'Curaçao'),
('DK', 'Danemark'),
('DJ', 'Djibouti'),
('DO', 'Dominicaine, République'),
('DM', 'Dominique'),
('EG', 'Egypte'),
('SV', 'El Salvador'),
('AE', 'Emirats arabes unis'),
('EC', 'Equateur'),
('ER', 'Erythrée'),
('ES', 'Espagne'),
('EE', 'Estonie'),
('US', 'Etats-Unis d''Amérique'),
('ET', 'Ethiopie'),
('FK', 'Falkland/Malouines (Îles)'),
('FO', 'Féroé, îles'),
('FJ', 'Fidji'),
('FI', 'Finlande'),
('FR', 'France'),
('GA', 'Gabon'),
('GM', 'Gambie'),
('GE', 'Géorgie'),
('GS', 'Géorgie du sud et les îles Sandwich du sud'),
('GH', 'Ghana'),
('GI', 'Gibraltar'),
('GR', 'Grèce'),
('GD', 'Grenade'),
('GL', 'Groenland'),
('GP', 'Guadeloupe'),
('GU', 'Guam'),
('GT', 'Guatemala'),
('GG', 'Guernesey'),
('GN', 'Guinée'),
('GW', 'Guinée-Bissau'),
('GQ', 'Guinée équatoriale'),
('GY', 'Guyana'),
('GF', 'Guyane française'),
('HT', 'Haïti'),
('HM', 'Heard, Ile et MacDonald, îles'),
('HN', 'Honduras'),
('HK', 'Hong Kong'),
('HU', 'Hongrie'),
('IM', 'Île de Man'),
('UM', 'Îles mineures éloignées des Etats-Unis'),
('VG', 'Îles vierges britanniques'),
('VI', 'Îles vierges des Etats-Unis'),
('IN', 'Inde'),
('IO', 'Indien (Territoire britannique de l''océan)'),
('ID', 'Indonésie'),
('IR', 'Iran, République islamique d'''),
('IQ', 'Iraq'),
('IE', 'Irlande'),
('IS', 'Islande'),
('IL', 'Israël'),
('IT', 'Italie'),
('JM', 'Jamaïque'),
('JP', 'Japon'),
('JE', 'Jersey'),
('JO', 'Jordanie'),
('KZ', 'Kazakhstan'),
('KE', 'Kenya'),
('KG', 'Kirghizistan'),
('KI', 'Kiribati'),
('KW', 'Koweït'),
('LA', 'Lao, République démocratique populaire'),
('LS', 'Lesotho'),
('LV', 'Lettonie'),
('LB', 'Liban'),
('LR', 'Libéria'),
('LY', 'Libye'),
('LI', 'Liechtenstein'),
('LT', 'Lituanie'),
('LU', 'Luxembourg'),
('MO', 'Macao'),
('MK', 'Macédoine, l''ex-République yougoslave de'),
('MG', 'Madagascar'),
('MY', 'Malaisie'),
('MW', 'Malawi'),
('MV', 'Maldives'),
('ML', 'Mali'),
('MT', 'Malte'),
('MP', 'Mariannes du nord, Iles'),
('MA', 'Maroc'),
('MH', 'Marshall, Iles'),
('MQ', 'Martinique'),
('MU', 'Maurice'),
('MR', 'Mauritanie'),
('YT', 'Mayotte'),
('MX', 'Mexique'),
('FM', 'Micronésie, Etats Fédérés de'),
('MD', 'Moldova, République de'),
('MC', 'Monaco'),
('MN', 'Mongolie'),
('ME', 'Monténégro'),
('MS', 'Montserrat'),
('MZ', 'Mozambique'),
('MM', 'Myanmar'),
('NA', 'Namibie'),
('NR', 'Nauru'),
('NP', 'Népal'),
('NI', 'Nicaragua'),
('NE', 'Niger'),
('NG', 'Nigéria'),
('NU', 'Niue'),
('NF', 'Norfolk, Ile'),
('NO', 'Norvège'),
('NC', 'Nouvelle-Calédonie'),
('NZ', 'Nouvelle-Zélande'),
('OM', 'Oman'),
('UG', 'Ouganda'),
('UZ', 'Ouzbékistan'),
('PK', 'Pakistan'),
('PW', 'Palaos'),
('PS', 'Palestine, Etat de'),
('PA', 'Panama'),
('PG', 'Papouasie-Nouvelle-Guinée'),
('PY', 'Paraguay'),
('NL', 'Pays-Bas'),
('XX', 'Pays inconnu'),
('ZZ', 'Pays multiples'),
('PE', 'Pérou'),
('PH', 'Philippines'),
('PN', 'Pitcairn'),
('PL', 'Pologne'),
('PF', 'Polynésie française'),
('PR', 'Porto Rico'),
('PT', 'Portugal'),
('QA', 'Qatar'),
('SY', 'République arabe syrienne'),
('CF', 'République centrafricaine'),
('RE', 'Réunion'),
('RO', 'Roumanie'),
('GB', 'Royaume-Uni de Grande-Bretagne et d''Irlande du Nord'),
('RU', 'Russie, Fédération de'),
('RW', 'Rwanda'),
('EH', 'Sahara occidental'),
('BL', 'Saint-Barthélemy'),
('KN', 'Saint-Kitts-et-Nevis'),
('SM', 'Saint-Marin'),
('MF', 'Saint-Martin (partie française)'),
('SX', 'Saint-Martin (partie néerlandaise)'),
('PM', 'Saint-Pierre-et-Miquelon'),
('VA', 'Saint-Siège'),
('VC', 'Saint-Vincent-et-les-Grenadines'),
('SH', 'Sainte-Hélène, Ascension et Tristan da Cunha'),
('LC', 'Sainte-Lucie'),
('SB', 'Salomon, Iles'),
('WS', 'Samoa'),
('AS', 'Samoa américaines'),
('ST', 'Sao Tomé-et-Principe'),
('SN', 'Sénégal'),
('RS', 'Serbie'),
('SC', 'Seychelles'),
('SL', 'Sierra Leone'),
('SG', 'Singapour'),
('SK', 'Slovaquie'),
('SI', 'Slovénie'),
('SO', 'Somalie'),
('SD', 'Soudan'),
('SS', 'Soudan du Sud'),
('LK', 'Sri Lanka'),
('SE', 'Suède'),
('CH', 'Suisse'),
('SR', 'Suriname'),
('SJ', 'Svalbard et île Jan Mayen'),
('SZ', 'Swaziland'),
('TJ', 'Tadjikistan'),
('TW', 'Taïwan, Province de Chine'),
('TZ', 'Tanzanie, République unie de'),
('TD', 'Tchad'),
('CS', 'Tchécoslovaquie'),
('CZ', 'Tchèque, République'),
('TF', 'Terres australes françaises'),
('TH', 'Thaïlande'),
('TL', 'Timor-Leste'),
('TG', 'Togo'),
('TK', 'Tokelau'),
('TO', 'Tonga'),
('TT', 'Trinité-et-Tobago'),
('TN', 'Tunisie'),
('TM', 'Turkménistan'),
('TC', 'Turks-et-Caïcos (Îles)'),
('TR', 'Turquie'),
('TV', 'Tuvalu'),
('UA', 'Ukraine'),
('SU', 'URSS'),
('UY', 'Uruguay'),
('VU', 'Vanuatu'),
('VE', 'Venezuela (République bolivarienne du)'),
('VN', 'Viet Nam'),
('VD', 'Viet Nam (Sud)'),
('WF', 'Wallis et Futuna'),
('YE', 'Yémen'),
('YU', 'Yougoslavie'),
('ZR', 'Zaïre'),
('ZM', 'Zambie'),
('ZW', 'Zimbabwe');


INSERT INTO type_vehicule (code_type_vehicule, libelle_type_vehicule)
VALUES ('TV1', 'VP'),
       ('TV2', 'PICK-UP'),
       ('TV3', 'BUS'),
       ('TV4', 'CAMIONNETTE'),
       ('TV5', '4x4');


INSERT INTO type_energie (code_type_energie, libelle_type_energie)
VALUES ('ESSENCE', 'ESSENCE'),
       ('GASOIL', 'GASOIL'),
       ('ELECTRIQUE', 'ELECTRIQUE'),
       ('HYBRIDE', 'HYBRIDE');


INSERT INTO marque_vehicule (code_marque, libelle_marque)
VALUES 
    ('ALF', 'Alfa Romeo'),
    ('AST', 'Aston Martin'),
    ('AUD', 'Audi'),
    ('BEN', 'Bentley'),
    ('BMW', 'BMW'),
    ('CAD', 'Cadillac'),
    ('CHE', 'Chevrolet'),
    ('CIT', 'Citroën'),
    ('FIAT', 'Fiat'),
    ('FOR', 'Ford'),
    ('HON', 'Honda'),
    ('HYU', 'Hyundai'),
    ('JAG', 'Jaguar'),
    ('JEE', 'Jeep'),
    ('KIA', 'Kia'),
    ('LAN', 'Land Rover'),
    ('LEX', 'Lexus'),
    ('MAS', 'Maserati'),
    ('MAZ', 'Mazda'),
    ('MCL', 'McLaren'),
    ('MER', 'Mercedes'),
    ('MIN', 'MINI'),
    ('NISS', 'Nissan'),
    ('OPE', 'Opel'),
    ('POR', 'Porsche'),
    ('REN', 'Renault'),
    ('ROL', 'Rolls-Royce'),
    ('SSA', 'SSANGYONG'),
    ('SUB', 'Subaru'),
    ('TES', 'Tesla'),
    ('TOY', 'Toyota'),
    ('VOL', 'Volkswagen'),
    ('VOLV', 'Volvo');


INSERT INTO etat_vehicule (code_etat, libelle_etat)
VALUES 
    ('NEUF', 'NEUF'),
    ('USAGE', 'USAGÉ');



INSERT INTO lieu_stockage_vehicule (code_lieu_vh, libellle_lieu_vh,nombre_limite_stockage_vh)
VALUES ('PKN', 'pikine',50),
       ('CLB', 'colobane',100),
       ('LB6', 'liberté 6',200),
       ('HGY', 'hlm grand yoff',40);


   
    -- Insertion des données dans la table article_bon_entree
INSERT INTO article_bon_entree (identifiant_b_e, code_article_bon_entree, code_type_objet, libelle_article_bon_entree, quantite_entree, date_enregistrement, matricule_agent, code_corps_agent,code_lieu_vh)
VALUES 
    ('BESA202312011043210', 'Article 1', 'ARMES', 'TOYOTA-CAMRY-123456', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1','PKN'),
    ('BESM202312021143211', 'Article 1', 'VEHIC', 'FORD-MUSTANG-789012', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2','CLB'),
    ('BESM202312021143211', 'Article 2', 'VEHIC', 'FORD-ESCAPE-789013', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2','LB6'),
    ('BESG202312031243213', 'Article 1', 'ARMES', 'BMW-X5-345678', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3','HGY');



INSERT INTO vehicule (numero_serie, numero_immatriculation, identifiant_b_e, code_article_bon_entree, modele, code_etat, code_type_energie, code_pays, numero_carte_grise, date_mise_en_circulation, code_type_vehicule, code_marque)
VALUES 
    ('123456', 'ABC123', 'BESA202312011043210', 'Article 1', 'CAMRY', 'NEUF', 'ESSENCE', 'US', 'CG123', '2023-01-01', 'TV1', 'TOY'),
    ('789012', 'XYZ789', 'BESM202312021143211', 'Article 1', 'MUSTANG', 'NEUF', 'GASOIL', 'JP', 'CG789', '2023-02-02', 'TV2', 'FOR'),
    ('789013', 'XYZ789', 'BESM202312021143211', 'Article 2', 'ESCAPE', 'NEUF', 'GASOIL', 'JP', 'CG789', '2023-02-02', 'TV2', 'FOR'),
    ('345678', 'DEF345', 'BESG202312031243213', 'Article 1', 'X5', 'USAGE', 'HYBRIDE', 'FR', 'CG345', '2023-03-03', 'TV3', 'BMW');


INSERT INTO bon_pour (identifiant_b_p, description_b_p, numero_courriel_origine, date_courriel_origine, etat_b_p, object_courriel_origine, numero_arrive_d_l_f, date_arrive_d_l_f, observation_d_l_f, numero_arrive_b_l_m, date_arrive_b_l_m, observation_b_l_m, numero_arrive_section, date_arrive_section, observation_section, code_unite_douaniere, code_section, date_enregistrement, matricule_agent, code_corps_agent) 
VALUES 
    ('BPSG202311121243214', 'Description 1', 123, '2024-01-24', 'Initial', 'Objet 1', 456, '2024-01-25', 'Observation 1', 789, '2024-01-26', 'Observation 1', 101, '2024-01-27', 'Observation 1', '06Z', 'SG', CURRENT_TIMESTAMP, 'MAT001', 'CP1'),
    ('BPSG202311121243215', 'Description 2', 124, '2024-01-25', 'Initial', 'Objet 2', 457, '2024-01-26', 'Observation 1', 790, '2024-01-27', 'Observation 1', 102, '2024-01-28', 'Observation 1', '06Z', 'SG', CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
    ('BPSG202311121243216', 'Description 3', 125, '2024-01-26', 'Initial', 'Objet 3', 458, '2024-01-27', 'Observation 1', 791, '2024-01-28', 'Observation 1', 103, '2024-01-29', 'Observation 1', '06K', 'SG', CURRENT_TIMESTAMP, 'MAT003', 'CP3');


INSERT INTO article_bon_pour (identifiant_b_p, code_article_bon_pour, libelle_article_bon_pour, quantite_demandee, code_type_objet, matricule_agent, code_corps_agent) 
VALUES 
    ('BPSG202311121243214', 'Article 1', 'libelle article 1', 10, 'VEHIC', 'MAT001', 'CP1'),
    ('BPSG202311121243215', 'Article 1', 'libelle article 1', 20, 'VEHIC', 'MAT002', 'CP2'),
    ('BPSG202311121243216', 'Article 1', 'libelle article 1', 30, 'VEHIC', 'MAT003', 'CP3');


INSERT INTO bon_de_sortie (identifiant_b_s, numero_b_s, description_b_s, date_b_s, identifiant_b_p, matricule_agent, code_corps_agent) 
VALUES 
    ('BSSG202311121243214', 'BS001', 'Description BS1', '2024-01-24',  'BPSG202311121243214', 'MAT001', 'CP1'),
    ('BSSG202311121243215', 'BS002', 'Description BS2', '2024-01-25',  'BPSG202311121243215', 'MAT002', 'CP2'),
    ('BSSG202311121243216', 'BS003', 'Description BS3', '2024-01-26',  'BPSG202311121243216', 'MAT003', 'CP3');


INSERT INTO article_bon_sortie (identifiant_b_s, code_article_bon_sortie, libelle_article_bon_sortie, quantite_accordee, date_article_bon_sortie, matricule_agent, code_corps_agent) 
VALUES 
    ('BSSG202311121243214', 'Article 1', 'Article BS1', 5, '2024-01-24', 'MAT001', 'CP1'),
    ('BSSG202311121243215', 'Article 1', 'Article BS2', 10, '2024-01-25', 'MAT002', 'CP2'),
    ('BSSG202311121243216', 'Article 1', 'Article BS3', 15, '2024-01-26', 'MAT003', 'CP3');


INSERT INTO dotation_vehicule ( identifiant_d_v, date_dotation, identifiant_b_s, code_article_bon_sortie, matricule_agent, code_corps_agent)  
VALUES 
    ('DVSG202311121243214', '2024-01-24', 'BSSG202311121243214', 'Article 1', 'MAT001', 'CP1'),
    ('DVSG202311121243215', '2024-01-23', 'BSSG202311121243215', 'Article 1', 'MAT002', 'CP2'),
    ('DVSG202311121243216', '2024-01-22', 'BSSG202311121243216', 'Article 1', 'MAT003', 'CP3');



INSERT INTO dotation_vehicule_vehicule ( numero_serie, identifiant_d_v)  
VALUES 
    ( '123456', 'DVSG202311121243214'),
    ( '789012', 'DVSG202311121243215'),
    ( '789013', 'DVSG202311121243216');




SELECT * FROM fonction_agent;
SELECT * FROM corps_agent;
SELECT * FROM type_unite_douaniere;
SELECT * FROM marque_vehicule;
SELECT * FROM etat_vehicule; 
SELECT * FROM type_vehicule;
SELECT * FROM type_energie;
SELECT * FROM prestataires;
SELECT * FROM secteur_activite;
SELECT * FROM prestataires_secteur;
SELECT * FROM unite_douaniere;
SELECT * FROM sections;
SELECT * FROM type_objet;
SELECT * FROM agent;
SELECT * FROM bordereau_livraison;
SELECT * FROM bon_entree;
SELECT * FROM article_bon_entree;
SELECT * FROM pays;
SELECT * FROM vehicule;
SELECT * FROM bon_pour;
SELECT * FROM article_bon_pour;
SELECT * FROM bon_de_sortie;
SELECT * FROM article_bon_sortie;
SELECT * FROM dotation_vehicule;





