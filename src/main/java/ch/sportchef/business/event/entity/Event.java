/**
 * SportChef – Sports Competition Management Software
 * Copyright (C) 2015 Marcus Fihlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/ <http://www.gnu.org/licenses/>>.
 */
package ch.sportchef.business.event.entity;

import ch.sportchef.business.adapter.LocalDateAdapter;
import ch.sportchef.business.adapter.LocalTimeAdapter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long eventId;

    @Version
    private Long version;

    @Size(min = 1)
    private String title;

    private String location;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;

    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime time;

    public Event() {
        super();
    }

    public Event(@NotNull final Long eventId,
                 @NotNull final String title,
                 @NotNull final String location,
                 @NotNull final LocalDate date,
                 @NotNull final LocalTime time) {
        this();
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
