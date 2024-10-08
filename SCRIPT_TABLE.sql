-- CRÉATION DE LA BASE DE DONNÉES GESTION_PATRIMOINE
CREATE DATABASE DLF_PATRIMOINE;

-- ------------------------------------------
-- -- -- -- TABLES DE REFERENCE
-- ------------------------------------------

CREATE TABLE TYPEUNITEDOUANIERE (
    CODETYPEUNITEDOUANIERE VARCHAR(5) PRIMARY KEY,
    LIBELLETYPEUNITEDOUANIERE VARCHAR(100)
);

CREATE TABLE SECTEURACTIVITE (
    CODESECTEURACTIVITE VARCHAR(10) PRIMARY KEY,
    LIBELLESECTEURACTIVITE VARCHAR(255)
);

CREATE TABLE TYPEVEHICULE (
    CODETYPEVEHICULE VARCHAR(25) PRIMARY KEY,
    LIBELLETYPEVEHICULE VARCHAR(100)
);

CREATE TABLE FONCTIONAGENT (
    CODEFONCTIONAGENT VARCHAR(10) PRIMARY KEY,
    LIBELLEFONCTIONAGENT VARCHAR(100)
);

CREATE TABLE CORPSAGENT (
    CODECORPSAGENT VARCHAR(5) PRIMARY KEY,
    LIBELLECORPSAGENT VARCHAR(100)
);

CREATE TABLE UNITEDOUANIERE (
    CODEUNITEDOUANIERE VARCHAR(3) PRIMARY KEY,
    NOMUNITEDOUANIERE VARCHAR(255),
    EFFECTIFUNITEDOUANIERE INT,
    NOMBREARME INT,
    NOMBREAUTOMOBILE INT,
    NOMBREMATERIEL INT,
    CODETYPEUNITEDOUANIERE VARCHAR(5),
    FOREIGN KEY (CODETYPEUNITEDOUANIERE) REFERENCES TYPEUNITEDOUANIERE(CODETYPEUNITEDOUANIERE)
);

CREATE TABLE SECTIONS (
    CODESECTION VARCHAR(3) PRIMARY KEY,
    LIBELLESECTION VARCHAR(100),
    CODEUNITEDOUANIERE VARCHAR(3),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE)
);

CREATE TABLE AGENT (
    MATRICULEAGENT VARCHAR(7) PRIMARY KEY,
    CODEAGENT VARCHAR(5) UNIQUE,
    NOMAGENT VARCHAR(100),
    PRENOMAGENT VARCHAR(255),
    NUMEROTELEPHONEAGENT INT,
    CODEFONCTIONAGENT VARCHAR(10),
    CODEUNITEDOUANIERE VARCHAR(3),
    CODECORPSAGENT VARCHAR(3) PRIMARY KEY,
    FOREIGN KEY (CODEFONCTIONAGENT) REFERENCES FONCTIONAGENT(CODEFONCTIONAGENT),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (CODECORPSAGENT) REFERENCES CORPSAGENT(CODECORPSAGENT)
);

CREATE TABLE TYPEOBJET (
    CODETYPEOBJET VARCHAR(5) PRIMARY KEY,
    LIBELLETYPEOBJET VARCHAR(100)
    CODESECTION VARCHAR(3),
    FOREIGN KEY (CODESECTION) REFERENCES SECTIONS(CODESECTION)
);

CREATE TABLE PRESTATAIRES (
    NINEA VARCHAR(20) PRIMARY KEY,
    RAISONSOCIALE VARCHAR(512),
    NUMEROTELEPHONE INT,
    ADRESSE VARCHAR(512),
);

CREATE TABLE PRESTATAIRESSECTEUR (
    NINEA VARCHAR(20) PRIMARY KEY,
    CODESECTEURACTIVITE VARCHAR(10) PRIMARY KEY,
    FOREIGN KEY (NINEA) REFERENCES PRESTATAIRES(NINEA),
    FOREIGN KEY (CODESECTEURACTIVITE) REFERENCES SECTEURACITIVITE(CODESECTEURACTIVITE)
);

-- ------------------------------------------
-- -- -- -- BORDEREAU DE LIVRAISON
-- ------------------------------------------

CREATE TABLE BORDEREAULIVRAISON (
    IDENTIFIANTBL VARCHAR(25) PRIMARY KEY, -- exemple : BLSA202311121243214 (SA+heure en timestamp)
    NUMEROBL VARCHAR(100),
    DESCRIPTIONBL VARCHAR(512),
    LIEUDELIVRAISON VARCHAR(255),
    DATEBL DATE,
    CONFORMITEBL VARCHAR(3),
    NINEA VARCHAR(20),
    NOMLIVREUR VARCHAR(512),
    CODESECTION VARCHAR(3),
    MATRICULEAGENT VARCHAR(7),
    DATEENREGISTREMENT TIMESTAMP,
    FOREIGN KEY (CODESECTION) REFERENCES SECTIONS(CODESECTION);
    FOREIGN KEY (NINEA) REFERENCES PRESTATAIRES(NINEA);
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
);

-- ------------------------------------------
-- -- -- -- BON D ENTREE
-- ------------------------------------------

CREATE TABLE BONENTREE (
    IDENTIFIANTBE VARCHAR(25) PRIMARY KEY, -- exemple : BESG202311121243214 (SG+heure en timestamp)
    NUMEROBE VARCHAR(100),
    LIBELLEBONENTREE VARCHAR(255),
    DATEBONENTREE DATE,
    OBSERVATIONBONENTREE VARCHAR(255),
    IDENTIFIANTBL VARCHAR(25),
    DATEENREGISTREMENT TIMESTAMP,
    MATRICULEAGENT VARCHAR(7),
    CODESECTION VARCHAR(3),
    FOREIGN KEY (CODESECTION) REFERENCES SECTIONS(CODESECTION)
    FOREIGN KEY (IDENTIFIANTBL) REFERENCES BORDEREAULIVRAISON(IDENTIFIANTBL)
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
);

CREATE TABLE ARTICLEBONENTREE (
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    -- NUMEROBE INT,
    CODETYPEOBJET VARCHAR(5), 
    LIBELLEARTICLEBONENTREE VARCHAR(255),
    QUANTITEENTREE INT,
    DATEENREGISTREMENTART TIMESTAMP,
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (NUMEROBE) REFERENCES BONENTREE(NUMEROBE),
    FOREIGN KEY (CODETYPEOBJET) REFERENCES TYPEOBJET(CODETYPEOBJET),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    PRIMARY KEY (IDENTIFIANTBE, CODEARTICLEBONENTREE)
);

-- ------------------------------------------
-- -- -- -- BON POUR
-- ------------------------------------------

CREATE TABLE BONPOUR (
    IDENTIFIANTBP VARCHAR(25) PRIMARY KEY, -- exemple : BPSG202311121243214 (SG+heure en timestamp)
    DESCRIPTIONBONPOUR VARCHAR(100),
    NUMEROCOURRIERORIGINE INT,
    DATECOURRIERORIGINE DATE,
    ETATBONPOUR VARCHAR(10),
    OBJECTCOURRIERORIGINE VARCHAR(255),
    NUMEROARRIVEDLF INT,
    DATEARRIVEDLF DATE,
    NUMEROARRIVEBLM INT,
    DATEARRIVEBLM DATE,
    NUMEROARRIVESECTION INT,
    DATEARRIVESECTION DATE,
    CODEUNITEDOUANIERE VARCHAR(3),
    OBSERVATIONBONPOUR VARCHAR(255),
    CODESECTION VARCHAR(3),
    DATEENREGISTREMENT TIMESTAMP,
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (CODESECTION) REFERENCES SECTIONS(CODESECTION),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
);

CREATE TABLE ARTICLEBONPOUR (
    IDENTIFIANTBP VARCHAR(25),
    CODEARTICLEBONPOUR INT,
    LIBELLEARTICLEBONPOUR VARCHAR(100),
    QUANTITEDEMANDEE INT,
    CODETYPEOBJET VARCHAR(20),
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (IDENTIFIANTBP) REFERENCES BONPOUR(IDENTIFIANTBP),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    PRIMARY KEY (IDENTIFIANTBP, CODEARTICLEBONPOUR)
);

-- ------------------------------------------
-- -- -- -- BON DE SORTIE
-- ------------------------------------------

CREATE TABLE BONDESORTIE (
    IDENTIFIANTBS VARCHAR(25) PRIMARY KEY, -- exemple : BSSG202311121243214 (SG+heure en timestamp)
    NUMEROBONDESORTIE VARCHAR(100),
    DESCRIPTIONBONDESORTIE VARCHAR(255),
    DATEBONDESORTIE DATE,
    OBSERVATIONBONDESORTIE VARCHAR(255),
    CODEUNITEDOUANIERE VARCHAR(3),
    CODESECTION VARCHAR(3),
    DATEENREGISTREMENT TIMESTAMP,
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (CODESECTION) REFERENCES SECTIONS(CODESECTION),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
);

CREATE TABLE ARTICLEBONSORTIE (
    IDENTIFIANTBS VARCHAR(25),
    CODEARTICLEBONSORTIE INT,
    LIBELLEARTICLEBONSORTIE VARCHAR(255),
    QUANTITEACCORDEE INT,
    DATEARTICLEBONSORTIE TIMESTAMP,
    IDENTIFIANTBP VARCHAR(25),
    CODEARTICLEBONPOUR INT,
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    NUMEROBONDESORTIE VARCHAR(10),
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (IDENTIFIANTBS) REFERENCES BONDESORTIE(IDENTIFIANTBS),
    FOREIGN KEY (IDENTIFIANTBP, CODEARTICLEBONPOUR) REFERENCES ARTICLEBONPOUR(IDENTIFIANTBP, CODEARTICLEBONPOUR),
    FOREIGN KEY (IDENTIFIANTBE, CODEARTICLEBONENTREE) REFERENCES ARTICLEBONPOUR(IDENTIFIANTBE, CODEARTICLEBONENTREE),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    PRIMARY KEY (IDENTIFIANTBS, CODEARTICLEBONSORTIE)
    
);

-- ------------------------------------------
-- -- -- -- PATRIMOINE (ARMES, VEHICULES, MTERIELS)
-- ------------------------------------------

-- ------------------------------------------
-- -- -- -- 1. MATERIELS
-- ------------------------------------------
??????????????????????????????
CREATE TABLE MATERIELS (
    CODEMATERIEL VARCHAR(5) PRIMARY KEY,
    LIBELLEMATERIEL VARCHAR(100),
    QUANTITEDISPONIBLE INT,
    NUMEROBONDESORTIE VARCHAR(10),
    CODEARTICLEBONSORTIE VARCHAR(5),
    CODETYPEOBJET VARCHAR(5),
    NUMEROBONENTRE VARCHAR(10),
    CODEARTICLEBONENTRE VARCHAR(10),
    MATRICULEAGENT VARCHAR(7),
    FOREIGN KEY (CODETYPEOBJET) REFERENCES TYPEOBJET(CODETYPEOBJET),
    FOREIGN KEY (NUMEROBONDESORTIE, CODEARTICLEBONSORTIE) REFERENCES ARTICLEBONSORTIE(NUMEROBONDESORTIE, CODEARTICLEBONSORTIE),
    FOREIGN KEY (NUMEROBONENTRE, CODEARTICLEBONENTRE) REFERENCES ARTICLEBONENTRE(NUMEROBONENTRE, CODEARTICLEBONENTRE)
);

-- ------------------------------------------
-- -- -- -- 2. VEHICULES
-- ------------------------------------------

CREATE TABLE MARQUEVEHICULE(
    CODEMARQUE INT PRIMARY KEY,
    LIBELLEMARQUE VARCHAR(50),
);

CREATE TABLE VEHICULE (
    NUMEROSERIE VARCHAR(30) PRIMARY KEY,
    CODETYPEVEHICULE VARCHAR(10),
    NUMEROIMMATRICULATION VARCHAR(20),
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    GENRE VARCHAR(50),
    CODEMARQUE INT,
    MODELE VARCHAR(50),
    ETATVEHICULE VARCHAR(10),
    TYPEENERGIE VARCHAR(20),
    PROVENANCE VARCHAR(50),
    NUMEROCARTEGRISE VARCHAR(30),
    DATEMISEENCIRCULATION DATE,
    CODEUNITEDOUANIERE VARCHAR(3),
    MATRICULEAGENT VARCHAR(7),
    CODETYPEOBJET VARCHAR(5),
    FOREIGN KEY (CODETYPEVEHICULE) REFERENCES TYPEVEHICULE(CODETYPEVEHICULE),
    FOREIGN KEY (CODEMARQUE) REFERENCES MARQUEVEHICULE(CODEMARQUE),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    FOREIGN KEY (CODETYPEOBJET) REFERENCES TYPEOBJET(CODETYPEOBJET)
);

CREATE TABLE DOTATIONVEHICULE (
    NUMEROSERIE VARCHAR(30),
    DATEDOTATION TIMESTAMP,
    IDENTIFIANTBS VARCHAR(25),
    CODEARTICLEBONSORTIE INT,
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    MATRICULEAGENT VARCHAR(7),
    CODEUNITEDOUANIERE VARCHAR(3),
    FOREIGN KEY (IDENTIFIANTBE, CODEARTICLEBONENTREE) REFERENCES ARTICLEBONENTREE(IDENTIFIANTBE, CODEARTICLEBONENTREE),
    FOREIGN KEY (IDENTIFIANTBS, CODEARTICLEBONSORTIE) REFERENCES ARTICLEBONSORTIE(IDENTIFIANTBS, CODEARTICLEBONSORTIE),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
    PRIMARY KEY (NUMEROSERIE, DATEDOTATION)
);

CREATE TABLE MAINTENANCE (
    IDMAINTENANCE VARCHAR(25) PRIMARY KEY, -- exemple : MSG202311121243214 (SG+heure en timestamp)
    NUMEROSERIE VARCHAR(30),
    DATEDEBUTMAINTENANCE TIMESTAMP,
    DATEFINMAINTENANCE TIMESTAMP,
    TYPEMAINTENANCE VARCHAR(15),
    MOTIFREPARATION VARCHAR(15),
    RAPPORTINCIDENT VARCHAR(512),
    FOREIGN KEY (NUMEROSERIE) REFERENCES VEHICULE(NUMEROSERIE)
);

CREATE TABLE CONTROLE (
    IDMAINTENANCE VARCHAR(25) PRIMARY KEY,
    DATECONTROLE DATE,
    OBSERVATIONCONTROLE VARCHAR(100),
    FOREIGN KEY (IDMAINTENANCE) REFERENCES MAINTENANCE(IDMAINTENANCE)
);

CREATE TABLE VIDANGE (
    IDMAINTENANCE VARCHAR(25) PRIMARY KEY,
    DATEVIDANGE TIMESTAMP,
    REFERENCEHUILE VARCHAR(50),
    LIBELLEHUILE VARCHAR(255),
    QUANTITEMISEVEHICULE INT,
    FOREIGN KEY (IDMAINTENANCE) REFERENCES MAINTENANCE(IDMAINTENANCE)
);

CREATE TABLE CHANGEMENTPIECE (
    IDMAINTENANCE VARCHAR(25) PRIMARY KEY,
    DATECHANGEMENTPIECE DATE,
    NOMBREPIECESRECHANGEES INT,
    REFERENCEPIECES VARCHAR(512),
    OBSERVATIONCHANGEMENT VARCHAR(512)
);

CREATE TABLE PRESTATIONSMECANIQUES (
    IDMAINTENANCE VARCHAR(25) PRIMARY KEY,
    NINEA VARCHAR(20),
    DATEDEBUTPRESTATION DATE,
    DATEFINPRESTATION DATE,
    DESCRIPTIONPRESTATION VARCHAR(512),
    FOREIGN KEY (NINEA) REFERENCES PRESTATAIRES(NINEA);
);
-- ------------------------------------------
-- -- -- --  CARBURANT
-- ------------------------------------------

CREATE TABLE CARBURANTCARTES (
    NUMEROCARTE VARCHAR(20) PRIMARY KEY,
    MATRICULEAGENT VARCHAR(7),
    MONTANTMENSUEL DECIMAL,
    NINEA VARCHAR(20),
    TYPEENERGIE VARCHAR(20),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    FOREIGN KEY (NINEA) REFERENCES PRESTATAIRES(NINEA)
);

CREATE TABLE CHARGEMENTCARTE (
    NUMEROCARTE VARCHAR(20),
    DATECHARGEMENT DATE,
    MONTANTCHARGEMENT DECIMAL,
    PRIMARY KEY (NUMEROCARTE, DATECHARGEMENT)
);

CREATE TABLE RAVITAILLEMENTTICKETS (
    IDRAVITAILLEMENT VARCHAR(30) PRIMARY KEY, -- exemple BLM202311121243214 (BLM+heure en timestamp)
    TYPEENERGIE VARCHAR(20),
    NOMBRETICKET INT,
    LITRAGETOTAL INT,
    VALEURUNITAIRE DECIMAL,
    VALEURTOTALE DECIMAL,
    NINEA VARCHAR(20),
    NUMEROROBL VARCHAR(25),
    DATEBL DATE,
    DATEENREGISTREMENT TIMESTAMP,
    MATRICULEAGENT VARCHAR(7),
    LIBELLERAVITAILLEMENT
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    FOREIGN KEY (NINEA) REFERENCES PRESTATAIRES(NINEA),
);

CREATE TABLE DOTATIONTICKETS (
    IDDOTATON VARCHAR(30) PRIMARY KEY, -- exemple BLM202311121243214 (BLM+heure en timestamp)
    NOMBRETICKET INT,
    LITRAGETOTAL INT,
    TYPEENERGIE INT,
    MATRICULEAGENT VARCHAR(7),
    MOTIFDOTATION VARCHAR(20),
    MOTIFORDREMISSION VARCHAR(255),
    NUMEROORDREMISSION INT,
    DESTINATATIONMISSSION VARCHAR(100),
    CODEUNITEDOUANIERE VARCHAR(3),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE)
);

CREATE TABLE CARBURANTTICKETS (
    TYPEENERGIE VARCHAR(20) PRIMARY KEY,
    LITRAGEDISPONIBLE INT,
);

-- ------------------------------------------
-- -- -- -- 3. ARMES
-- ------------------------------------------

CREATE TABLE TYPEARME (
    CODETYPEARME VARCHAR(10) PRIMARY KEY,
    LIBELLETYPEARME VARCHAR(100)
);

CREATE TABLE MARQUEARME (
    CODEMARQUEARME VARCHAR(10) PRIMARY KEY,
    LIBELLEMARQUE VARCHAR(100)
);

CREATE TABLE ARMES (
    NUMEROSERIEARME VARCHAR(50) PRIMARY KEY,
    PAYSFABRICATION VARCHAR(30),
    DATERECUPERATIONARME DATE,
    ETATARME VARCHAR(10),
    CALIBRE INT,
    LIBELLESERIEARME VARCHAR(30),
    CODETYPEARME VARCHAR(10),
    CODEMARQUEARME VARCHAR(10),
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    IDENTIFIANTBS VARCHAR(25),
    CODEARTICLEBONSORTIE INT,
    CODETYPEOBJET VARCHAR(5),
    FOREIGN KEY (CODETYPEARME) REFERENCES TYPEARME(CODETYPEARME),
    FOREIGN KEY (CODEMARQUEARME) REFERENCES MARQUEARME(CODEMARQUEARME),
    FOREIGN KEY (IDENTIFIANTBS, CODEARTICLEBONSORTIE) REFERENCES ARTICLEBONSORTIE(IDENTIFIANTBS, CODEARTICLEBONSORTIE),
    FOREIGN KEY (IDENTIFIANTBE, CODEARTICLEBONENTREE) REFERENCES ARTICLEBONENTREE(IDENTIFIANTBE, CODEARTICLEBONENTREE),
    FOREIGN KEY (CODETYPEOBJET) REFERENCES TYPEOBJET(CODETYPEOBJET),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT),
);

CREATE TABLE DOTATIONARMES (
    NUMEROSERIEARME VARCHAR(50) PRIMARY KEY,
    DATEDOTATION TIMESTAMP,
    IDENTIFIANTBS VARCHAR(25),
    CODEARTICLEBONSORTIE INT,
    IDENTIFIANTBE VARCHAR(25),
    CODEARTICLEBONENTREE INT,
    MATRICULEAGENT VARCHAR(7),
    CODEUNITEDOUANIERE VARCHAR(3),
    FOREIGN KEY (IDENTIFIANTBE, CODEARTICLEBONENTREE) REFERENCES ARTICLEBONENTREE(IDENTIFIANTBE, CODEARTICLEBONENTREE),
    FOREIGN KEY (IDENTIFIANTBS, CODEARTICLEBONSORTIE) REFERENCES ARTICLEBONSORTIE(IDENTIFIANTBS, CODEARTICLEBONSORTIE),
    FOREIGN KEY (CODEUNITEDOUANIERE) REFERENCES UNITEDOUANIERE(CODEUNITEDOUANIERE),
    FOREIGN KEY (MATRICULEAGENT) REFERENCES AGENT(MATRICULEAGENT)
    PRIMARY KEY (NUMEROSERIE, DATEDOTATION)
);
