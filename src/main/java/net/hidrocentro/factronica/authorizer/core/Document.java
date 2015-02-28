package net.hidrocentro.factronica.authorizer.core;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "document")
public class Document {

    @Id
    private String id;
    private String accessKey;
    private String documentResource;
    @Lob
    private byte[] documentXml;

    public Document() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getDocumentResource() {
        return documentResource;
    }

    public void setDocumentResource(String documentResource) {
        this.documentResource = documentResource;
    }

    public byte[] getDocumentXml() {
        return documentXml;
    }

    public void setDocumentXml(byte[] documentXml) {
        this.documentXml = documentXml;
    }
}
