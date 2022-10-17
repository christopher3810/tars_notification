package com.tars_notification.notification.repository;

import com.tars_notification.notification.constants.MAIL_SERVER_PROTOCOL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;

@Entity
@Getter
@Table(indexes = {@Index(name = "Mail_Idx", unique = true, columnList = "id, host, username")})
public class MailServerConfig {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MAIL_SERVER_PROTOCOL protocol;

    @Column(columnDefinition = "VARCHAR(255)")
    private String host;

    @Column(columnDefinition = "VARCHAR(255)")
    private String userName;

    @Column(columnDefinition = "VARCHAR(255)")
    private String fromAddress;

    @Column(columnDefinition = "VARCHAR(255)")
    private String prefix;

    @Column(columnDefinition = "VARCHAR(255)")
    private String password;

    private int port;

    private Long timeout;

    private boolean tls;

    @Transient
    private boolean changePassword;

    public MailServerConfig() {
    }
}
