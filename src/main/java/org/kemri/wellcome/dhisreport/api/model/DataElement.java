/**
 *  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of DHIS2 Reporting module.
 *
 *  DHIS2 Reporting module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  DHIS2 Reporting module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DHIS2 Reporting module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/
package org.kemri.wellcome.dhisreport.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

/**
 *
 * @author bobj
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name = "dataElement" )
@Entity
@Table(name=DataElement.TABLE_NAME)
public class DataElement
    implements Serializable, Identifiable
{

    private static final long serialVersionUID = -5461921184708765617L;
    public static final String TABLE_NAME="dhisreport_dataelement";

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    protected Integer id;

    @XmlAttribute( required = true )
    @XmlID
    @Column(name="code", unique=true)
    protected String code;

    @XmlAttribute( required = true )
    @Column(name="uid", unique=true)
    protected String uid;

    @XmlAttribute( required = true )
    @Column(name="de_name", unique=true)
    protected String name;
    
    @OneToMany(mappedBy="dataelement", fetch = FetchType.LAZY)
    protected Set<DataValueTemplate> dataValueTemplates = new HashSet<DataValueTemplate>();

    @Override
    public String getUid()
    {
        return uid;
    }

    @Override
    public void setUid( String uid )
    {
        this.uid = uid;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final DataElement other = (DataElement) obj;
        if ( (this.code == null) ? (other.code != null) : !this.code.equals( other.code ) )
        {
            return false;
        }
        if ( (this.uid == null) ? (other.uid != null) : !this.uid.equals( other.uid ) )
        {
            return false;
        }
        if ( (this.name == null) ? (other.name != null) : !this.name.equals( other.name ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + (this.code != null ? this.code.hashCode() : 0);
        hash = 89 * hash + (this.uid != null ? this.uid.hashCode() : 0);
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString()
    {
        return "DE: " + this.getId() + " : " + this.getCode() + " : " + this.getUid() + " : " + this.getName();
    }
    
    public Set<DataValueTemplate> getDataValueTemplates() {
		return dataValueTemplates;
	}

	public void setDataValueTemplates(Set<DataValueTemplate> dataValueTemplates) {
		this.dataValueTemplates = dataValueTemplates;
	}

}
