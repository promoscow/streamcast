package ru.xpendence.streamcast.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.10.18
 * Time: 21:08
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "oauth_access_token")
@Getter
public class OAuthAccessToken extends AbstractEntity {


}
