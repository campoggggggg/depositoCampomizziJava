CREATE TABLE Palco (
    id_palco INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    capienza INT NOT NULL CHECK (capienza>0),
    tipologia VARCHAR(50) NOT NULL
);

CREATE TABLE Spettatore (
    id_spettatore INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
        telefono VARCHAR(20)
);

CREATE TABLE Biglietto (
    id_biglietto INT AUTO_INCREMENT PRIMARY KEY,
    id_spettatore NOT NULL,
    tipo_biglietto VARCHAR(30),
    prezzo DECIMAL(12,2) NOT NULL CHECK (prezzo >= 0),
    data_acquisto DATE NOT NULL,
    FOREIGN KEY (id_spettatore) REFERENCES Spettatore(id_spettatore)
);

CREATE TABLE Pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_biglietto INT NOT NULL UNIQUE,
    importo DECIMAL(10,2) NOT NULL CHECK (importo >= 0),
    metodo_pagamento VARCHAR(30) NOT NULL,
    data_pagamento DATE NOT NULL,
    FOREIGN KEY (id_biglietto) REFERENCES Biglietto(id_biglietto)
);

CREATE TABLE Staff (
id_staff INT AUTO_INCREMENT PRIMARY KEY,
id_palco INT NOT NULL,
nome        VARCHAR(60)     NOT NULL,
cognome     VARCHAR(60)     NOT NULL,
ruolo       VARCHAR(50)     NOT NULL CHECK (ruolo IN ('fonico', 'luci', 'sicurezza')),

FOREIGN KEY (id_palco) REFERENCES Palchi(id_palco)

);

CREATE TABLE Staff_palco (
    id_staff INT NOT NULL,
    id_palco INT NOT NULL,

    PRIMARY KEY(id_staff, id_palco),
    FOREIGN KEY (id_staff) REFERENCES Staff(id_staff),
    FOREIGN KEY (id_palco) REFERENCES Palco(id_palco)
);

CREATE TABLE sponsor (
id_sponsor INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL UNIQUE,
budget INT NOT NULL,
email VARCHAR(100) UNIQUE

);

CREATE TABLE Artista (
    id_artista INT AUTO_INCREMENT PRIMARY KEY,
    nome_arte VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(50) ,
    cognome VARCHAR(50),
    nazione VARCHAR(50),
    genere VARCHAR(50)
);

CREATE TABLE Band (
    id_band INT AUTO_INCREMENT PRIMARY KEY,
    nome_arte VARCHAR(100) NOT NULL UNIQUE,
    nazione VARCHAR(50),
    genere VARCHAR(50)
); 

CREATE TABLE Appartenenza (
    id_artista INT,
    id_band INT,
    PRIMARY KEY (id_artista, id_band),
    FOREIGN KEY (id_artista) REFERENCES Artista(id_artista)
        ON DELETE CASCADE,
    FOREIGN KEY (id_band) REFERENCES Band(id_band)
        ON DELETE CASCADE
);


CREATE TABLE Collaborazione (
    id_collaborazione INT AUTO_INCREMENT PRIMARY PRIMARY KEY,
    FOREIGN KEY (id_performance) REFERENCES Performance(id_performance)
        ON DELETE CASCADE
);

CREATE TABLE Partecipazione_Collaborazione_Band (
    id_collaborazione INT,
    id_band INT,
    PRIMARY KEY (id_collaborazione, id_band),
    FOREIGN KEY (id_collaborazione) REFERENCES Collaborazione(id_collaborazione)
        ON DELETE CASCADE,
    FOREIGN KEY (id_band) REFERENCES Artista(id_band)
        ON DELETE CASCADE
);


CREATE TABLE Sponsor (
    id_sponsor INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(20),
    importo_contratto DECIMAL(12,2) NOT NULL CHECK (importo_contratto >= 0)
);

CREATE TABLE Performance (
    id_performance INT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(100) NOT NULL,
    data_ora_inizio DATETIME NOT NULL,
    durata_minuti INT NOT NULL CHECK (durata_minuti > 0),
    id_palco INT NOT NULL,
    FOREIGN KEY (id_palco) REFERENCES Palco(id_palco)
);

CREATE TABLE SponsorPerformance (
    id_sponsor INT NOT NULL,
    id_performance INT NOT NULL,
    importo_sponsorizzazione DECIMAL(12,2) NOT NULL CHECK (importo_sponsorizzazione >= 0),
    PRIMARY KEY (id_sponsor, id_performance),
    FOREIGN KEY (id_sponsor) REFERENCES Sponsor(id_sponsor),
    FOREIGN KEY (id_performance) REFERENCES Performance(id_performance)
);