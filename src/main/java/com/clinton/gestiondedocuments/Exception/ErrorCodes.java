package com.clinton.gestiondedocuments.Exception;

public enum ErrorCodes {

    ACTION_NOT_FOUND(1000),
    ACTION_NOT_VALIDE(1001),
    ADMINISTRATION_NOT_FOUND(2000),
    ADMINISTRATION_NOT_VALIDE(2001),
    CATEGORIE_NOT_FOUND(3000),
    CATEGORIE_NOT_VALIDE(3001),
    DOCUMENT_NOT_FOUND(4000),
    DOCUMENT_NOT_VALIDE(4001),
    DROIT_NOT_FOUND(5000),
    DROIT_NOT_VALIDE(5001),
    DROIT_DOCUMENT_NOT_FOUND(6000),
    DROIT_DOCUMENT_NOT_VALIDE(6001),
    ENSEIGNANT_NOT_FOUND(7000),
    ENSEIGNANT_NOT_VALIDE(7001),
    ETUDIANT_NOT_FOUND(8000),
    ETUDIANT_NOT_VALIDE(8001),
    GROUPE_NOT_FOUND(9000),
    GROUPE_NOT_VALIDE(9001),
    HISTORIQUE_NOT_FOUND(10000),
    HISTORIQUE_NOT_VALIDE(10001),
    UTILISATEUR_NOT_FOUND(11000),
    UTILISATEUR_CHANGE_PASSWORD_NOT_VALID(11002),
    UTILISATEUR_NOT_VALIDE(11001),
    ;
    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
