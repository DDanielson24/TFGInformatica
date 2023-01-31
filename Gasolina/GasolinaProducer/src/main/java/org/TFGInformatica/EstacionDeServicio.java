/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.TFGInformatica;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EstacionDeServicio extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5532418258416590306L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EstacionDeServicio\",\"namespace\":\"org.TFGInformatica\",\"fields\":[{\"name\":\"direccion\",\"type\":\"string\"},{\"name\":\"municipio\",\"type\":\"string\"},{\"name\":\"localidad\",\"type\":\"string\"},{\"name\":\"codigoPostal\",\"type\":\"int\"},{\"name\":\"longitud\",\"type\":\"float\"},{\"name\":\"latitud\",\"type\":\"float\"},{\"name\":\"precioGasolina95\",\"type\":\"float\"},{\"name\":\"precioGasolina98\",\"type\":\"float\"},{\"name\":\"precioGasoleoA\",\"type\":\"float\"},{\"name\":\"precioGasoleoPremium\",\"type\":\"float\"},{\"name\":\"rotulo\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EstacionDeServicio> ENCODER =
      new BinaryMessageEncoder<EstacionDeServicio>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EstacionDeServicio> DECODER =
      new BinaryMessageDecoder<EstacionDeServicio>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EstacionDeServicio> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EstacionDeServicio> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EstacionDeServicio> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EstacionDeServicio>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EstacionDeServicio to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EstacionDeServicio from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EstacionDeServicio instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EstacionDeServicio fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence direccion;
   private java.lang.CharSequence municipio;
   private java.lang.CharSequence localidad;
   private int codigoPostal;
   private float longitud;
   private float latitud;
   private float precioGasolina95;
   private float precioGasolina98;
   private float precioGasoleoA;
   private float precioGasoleoPremium;
   private java.lang.CharSequence rotulo;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EstacionDeServicio() {}

  /**
   * All-args constructor.
   * @param direccion The new value for direccion
   * @param municipio The new value for municipio
   * @param localidad The new value for localidad
   * @param codigoPostal The new value for codigoPostal
   * @param longitud The new value for longitud
   * @param latitud The new value for latitud
   * @param precioGasolina95 The new value for precioGasolina95
   * @param precioGasolina98 The new value for precioGasolina98
   * @param precioGasoleoA The new value for precioGasoleoA
   * @param precioGasoleoPremium The new value for precioGasoleoPremium
   * @param rotulo The new value for rotulo
   */
  public EstacionDeServicio(java.lang.CharSequence direccion, java.lang.CharSequence municipio, java.lang.CharSequence localidad, java.lang.Integer codigoPostal, java.lang.Float longitud, java.lang.Float latitud, java.lang.Float precioGasolina95, java.lang.Float precioGasolina98, java.lang.Float precioGasoleoA, java.lang.Float precioGasoleoPremium, java.lang.CharSequence rotulo) {
    this.direccion = direccion;
    this.municipio = municipio;
    this.localidad = localidad;
    this.codigoPostal = codigoPostal;
    this.longitud = longitud;
    this.latitud = latitud;
    this.precioGasolina95 = precioGasolina95;
    this.precioGasolina98 = precioGasolina98;
    this.precioGasoleoA = precioGasoleoA;
    this.precioGasoleoPremium = precioGasoleoPremium;
    this.rotulo = rotulo;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return direccion;
    case 1: return municipio;
    case 2: return localidad;
    case 3: return codigoPostal;
    case 4: return longitud;
    case 5: return latitud;
    case 6: return precioGasolina95;
    case 7: return precioGasolina98;
    case 8: return precioGasoleoA;
    case 9: return precioGasoleoPremium;
    case 10: return rotulo;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: direccion = (java.lang.CharSequence)value$; break;
    case 1: municipio = (java.lang.CharSequence)value$; break;
    case 2: localidad = (java.lang.CharSequence)value$; break;
    case 3: codigoPostal = (java.lang.Integer)value$; break;
    case 4: longitud = (java.lang.Float)value$; break;
    case 5: latitud = (java.lang.Float)value$; break;
    case 6: precioGasolina95 = (java.lang.Float)value$; break;
    case 7: precioGasolina98 = (java.lang.Float)value$; break;
    case 8: precioGasoleoA = (java.lang.Float)value$; break;
    case 9: precioGasoleoPremium = (java.lang.Float)value$; break;
    case 10: rotulo = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'direccion' field.
   * @return The value of the 'direccion' field.
   */
  public java.lang.CharSequence getDireccion() {
    return direccion;
  }


  /**
   * Sets the value of the 'direccion' field.
   * @param value the value to set.
   */
  public void setDireccion(java.lang.CharSequence value) {
    this.direccion = value;
  }

  /**
   * Gets the value of the 'municipio' field.
   * @return The value of the 'municipio' field.
   */
  public java.lang.CharSequence getMunicipio() {
    return municipio;
  }


  /**
   * Sets the value of the 'municipio' field.
   * @param value the value to set.
   */
  public void setMunicipio(java.lang.CharSequence value) {
    this.municipio = value;
  }

  /**
   * Gets the value of the 'localidad' field.
   * @return The value of the 'localidad' field.
   */
  public java.lang.CharSequence getLocalidad() {
    return localidad;
  }


  /**
   * Sets the value of the 'localidad' field.
   * @param value the value to set.
   */
  public void setLocalidad(java.lang.CharSequence value) {
    this.localidad = value;
  }

  /**
   * Gets the value of the 'codigoPostal' field.
   * @return The value of the 'codigoPostal' field.
   */
  public int getCodigoPostal() {
    return codigoPostal;
  }


  /**
   * Sets the value of the 'codigoPostal' field.
   * @param value the value to set.
   */
  public void setCodigoPostal(int value) {
    this.codigoPostal = value;
  }

  /**
   * Gets the value of the 'longitud' field.
   * @return The value of the 'longitud' field.
   */
  public float getLongitud() {
    return longitud;
  }


  /**
   * Sets the value of the 'longitud' field.
   * @param value the value to set.
   */
  public void setLongitud(float value) {
    this.longitud = value;
  }

  /**
   * Gets the value of the 'latitud' field.
   * @return The value of the 'latitud' field.
   */
  public float getLatitud() {
    return latitud;
  }


  /**
   * Sets the value of the 'latitud' field.
   * @param value the value to set.
   */
  public void setLatitud(float value) {
    this.latitud = value;
  }

  /**
   * Gets the value of the 'precioGasolina95' field.
   * @return The value of the 'precioGasolina95' field.
   */
  public float getPrecioGasolina95() {
    return precioGasolina95;
  }


  /**
   * Sets the value of the 'precioGasolina95' field.
   * @param value the value to set.
   */
  public void setPrecioGasolina95(float value) {
    this.precioGasolina95 = value;
  }

  /**
   * Gets the value of the 'precioGasolina98' field.
   * @return The value of the 'precioGasolina98' field.
   */
  public float getPrecioGasolina98() {
    return precioGasolina98;
  }


  /**
   * Sets the value of the 'precioGasolina98' field.
   * @param value the value to set.
   */
  public void setPrecioGasolina98(float value) {
    this.precioGasolina98 = value;
  }

  /**
   * Gets the value of the 'precioGasoleoA' field.
   * @return The value of the 'precioGasoleoA' field.
   */
  public float getPrecioGasoleoA() {
    return precioGasoleoA;
  }


  /**
   * Sets the value of the 'precioGasoleoA' field.
   * @param value the value to set.
   */
  public void setPrecioGasoleoA(float value) {
    this.precioGasoleoA = value;
  }

  /**
   * Gets the value of the 'precioGasoleoPremium' field.
   * @return The value of the 'precioGasoleoPremium' field.
   */
  public float getPrecioGasoleoPremium() {
    return precioGasoleoPremium;
  }


  /**
   * Sets the value of the 'precioGasoleoPremium' field.
   * @param value the value to set.
   */
  public void setPrecioGasoleoPremium(float value) {
    this.precioGasoleoPremium = value;
  }

  /**
   * Gets the value of the 'rotulo' field.
   * @return The value of the 'rotulo' field.
   */
  public java.lang.CharSequence getRotulo() {
    return rotulo;
  }


  /**
   * Sets the value of the 'rotulo' field.
   * @param value the value to set.
   */
  public void setRotulo(java.lang.CharSequence value) {
    this.rotulo = value;
  }

  /**
   * Creates a new EstacionDeServicio RecordBuilder.
   * @return A new EstacionDeServicio RecordBuilder
   */
  public static org.TFGInformatica.EstacionDeServicio.Builder newBuilder() {
    return new org.TFGInformatica.EstacionDeServicio.Builder();
  }

  /**
   * Creates a new EstacionDeServicio RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EstacionDeServicio RecordBuilder
   */
  public static org.TFGInformatica.EstacionDeServicio.Builder newBuilder(org.TFGInformatica.EstacionDeServicio.Builder other) {
    if (other == null) {
      return new org.TFGInformatica.EstacionDeServicio.Builder();
    } else {
      return new org.TFGInformatica.EstacionDeServicio.Builder(other);
    }
  }

  /**
   * Creates a new EstacionDeServicio RecordBuilder by copying an existing EstacionDeServicio instance.
   * @param other The existing instance to copy.
   * @return A new EstacionDeServicio RecordBuilder
   */
  public static org.TFGInformatica.EstacionDeServicio.Builder newBuilder(org.TFGInformatica.EstacionDeServicio other) {
    if (other == null) {
      return new org.TFGInformatica.EstacionDeServicio.Builder();
    } else {
      return new org.TFGInformatica.EstacionDeServicio.Builder(other);
    }
  }

  /**
   * RecordBuilder for EstacionDeServicio instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EstacionDeServicio>
    implements org.apache.avro.data.RecordBuilder<EstacionDeServicio> {

    private java.lang.CharSequence direccion;
    private java.lang.CharSequence municipio;
    private java.lang.CharSequence localidad;
    private int codigoPostal;
    private float longitud;
    private float latitud;
    private float precioGasolina95;
    private float precioGasolina98;
    private float precioGasoleoA;
    private float precioGasoleoPremium;
    private java.lang.CharSequence rotulo;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.TFGInformatica.EstacionDeServicio.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.direccion)) {
        this.direccion = data().deepCopy(fields()[0].schema(), other.direccion);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.municipio)) {
        this.municipio = data().deepCopy(fields()[1].schema(), other.municipio);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.localidad)) {
        this.localidad = data().deepCopy(fields()[2].schema(), other.localidad);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.codigoPostal)) {
        this.codigoPostal = data().deepCopy(fields()[3].schema(), other.codigoPostal);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.longitud)) {
        this.longitud = data().deepCopy(fields()[4].schema(), other.longitud);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.latitud)) {
        this.latitud = data().deepCopy(fields()[5].schema(), other.latitud);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.precioGasolina95)) {
        this.precioGasolina95 = data().deepCopy(fields()[6].schema(), other.precioGasolina95);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.precioGasolina98)) {
        this.precioGasolina98 = data().deepCopy(fields()[7].schema(), other.precioGasolina98);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.precioGasoleoA)) {
        this.precioGasoleoA = data().deepCopy(fields()[8].schema(), other.precioGasoleoA);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.precioGasoleoPremium)) {
        this.precioGasoleoPremium = data().deepCopy(fields()[9].schema(), other.precioGasoleoPremium);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
      if (isValidValue(fields()[10], other.rotulo)) {
        this.rotulo = data().deepCopy(fields()[10].schema(), other.rotulo);
        fieldSetFlags()[10] = other.fieldSetFlags()[10];
      }
    }

    /**
     * Creates a Builder by copying an existing EstacionDeServicio instance
     * @param other The existing instance to copy.
     */
    private Builder(org.TFGInformatica.EstacionDeServicio other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.direccion)) {
        this.direccion = data().deepCopy(fields()[0].schema(), other.direccion);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.municipio)) {
        this.municipio = data().deepCopy(fields()[1].schema(), other.municipio);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.localidad)) {
        this.localidad = data().deepCopy(fields()[2].schema(), other.localidad);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.codigoPostal)) {
        this.codigoPostal = data().deepCopy(fields()[3].schema(), other.codigoPostal);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.longitud)) {
        this.longitud = data().deepCopy(fields()[4].schema(), other.longitud);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.latitud)) {
        this.latitud = data().deepCopy(fields()[5].schema(), other.latitud);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.precioGasolina95)) {
        this.precioGasolina95 = data().deepCopy(fields()[6].schema(), other.precioGasolina95);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.precioGasolina98)) {
        this.precioGasolina98 = data().deepCopy(fields()[7].schema(), other.precioGasolina98);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.precioGasoleoA)) {
        this.precioGasoleoA = data().deepCopy(fields()[8].schema(), other.precioGasoleoA);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.precioGasoleoPremium)) {
        this.precioGasoleoPremium = data().deepCopy(fields()[9].schema(), other.precioGasoleoPremium);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.rotulo)) {
        this.rotulo = data().deepCopy(fields()[10].schema(), other.rotulo);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'direccion' field.
      * @return The value.
      */
    public java.lang.CharSequence getDireccion() {
      return direccion;
    }


    /**
      * Sets the value of the 'direccion' field.
      * @param value The value of 'direccion'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setDireccion(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.direccion = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'direccion' field has been set.
      * @return True if the 'direccion' field has been set, false otherwise.
      */
    public boolean hasDireccion() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'direccion' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearDireccion() {
      direccion = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'municipio' field.
      * @return The value.
      */
    public java.lang.CharSequence getMunicipio() {
      return municipio;
    }


    /**
      * Sets the value of the 'municipio' field.
      * @param value The value of 'municipio'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setMunicipio(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.municipio = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'municipio' field has been set.
      * @return True if the 'municipio' field has been set, false otherwise.
      */
    public boolean hasMunicipio() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'municipio' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearMunicipio() {
      municipio = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'localidad' field.
      * @return The value.
      */
    public java.lang.CharSequence getLocalidad() {
      return localidad;
    }


    /**
      * Sets the value of the 'localidad' field.
      * @param value The value of 'localidad'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setLocalidad(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.localidad = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'localidad' field has been set.
      * @return True if the 'localidad' field has been set, false otherwise.
      */
    public boolean hasLocalidad() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'localidad' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearLocalidad() {
      localidad = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'codigoPostal' field.
      * @return The value.
      */
    public int getCodigoPostal() {
      return codigoPostal;
    }


    /**
      * Sets the value of the 'codigoPostal' field.
      * @param value The value of 'codigoPostal'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setCodigoPostal(int value) {
      validate(fields()[3], value);
      this.codigoPostal = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'codigoPostal' field has been set.
      * @return True if the 'codigoPostal' field has been set, false otherwise.
      */
    public boolean hasCodigoPostal() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'codigoPostal' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearCodigoPostal() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'longitud' field.
      * @return The value.
      */
    public float getLongitud() {
      return longitud;
    }


    /**
      * Sets the value of the 'longitud' field.
      * @param value The value of 'longitud'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setLongitud(float value) {
      validate(fields()[4], value);
      this.longitud = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'longitud' field has been set.
      * @return True if the 'longitud' field has been set, false otherwise.
      */
    public boolean hasLongitud() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'longitud' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearLongitud() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'latitud' field.
      * @return The value.
      */
    public float getLatitud() {
      return latitud;
    }


    /**
      * Sets the value of the 'latitud' field.
      * @param value The value of 'latitud'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setLatitud(float value) {
      validate(fields()[5], value);
      this.latitud = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'latitud' field has been set.
      * @return True if the 'latitud' field has been set, false otherwise.
      */
    public boolean hasLatitud() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'latitud' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearLatitud() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'precioGasolina95' field.
      * @return The value.
      */
    public float getPrecioGasolina95() {
      return precioGasolina95;
    }


    /**
      * Sets the value of the 'precioGasolina95' field.
      * @param value The value of 'precioGasolina95'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setPrecioGasolina95(float value) {
      validate(fields()[6], value);
      this.precioGasolina95 = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'precioGasolina95' field has been set.
      * @return True if the 'precioGasolina95' field has been set, false otherwise.
      */
    public boolean hasPrecioGasolina95() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'precioGasolina95' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearPrecioGasolina95() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'precioGasolina98' field.
      * @return The value.
      */
    public float getPrecioGasolina98() {
      return precioGasolina98;
    }


    /**
      * Sets the value of the 'precioGasolina98' field.
      * @param value The value of 'precioGasolina98'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setPrecioGasolina98(float value) {
      validate(fields()[7], value);
      this.precioGasolina98 = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'precioGasolina98' field has been set.
      * @return True if the 'precioGasolina98' field has been set, false otherwise.
      */
    public boolean hasPrecioGasolina98() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'precioGasolina98' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearPrecioGasolina98() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'precioGasoleoA' field.
      * @return The value.
      */
    public float getPrecioGasoleoA() {
      return precioGasoleoA;
    }


    /**
      * Sets the value of the 'precioGasoleoA' field.
      * @param value The value of 'precioGasoleoA'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setPrecioGasoleoA(float value) {
      validate(fields()[8], value);
      this.precioGasoleoA = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'precioGasoleoA' field has been set.
      * @return True if the 'precioGasoleoA' field has been set, false otherwise.
      */
    public boolean hasPrecioGasoleoA() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'precioGasoleoA' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearPrecioGasoleoA() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'precioGasoleoPremium' field.
      * @return The value.
      */
    public float getPrecioGasoleoPremium() {
      return precioGasoleoPremium;
    }


    /**
      * Sets the value of the 'precioGasoleoPremium' field.
      * @param value The value of 'precioGasoleoPremium'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setPrecioGasoleoPremium(float value) {
      validate(fields()[9], value);
      this.precioGasoleoPremium = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'precioGasoleoPremium' field has been set.
      * @return True if the 'precioGasoleoPremium' field has been set, false otherwise.
      */
    public boolean hasPrecioGasoleoPremium() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'precioGasoleoPremium' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearPrecioGasoleoPremium() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'rotulo' field.
      * @return The value.
      */
    public java.lang.CharSequence getRotulo() {
      return rotulo;
    }


    /**
      * Sets the value of the 'rotulo' field.
      * @param value The value of 'rotulo'.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder setRotulo(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.rotulo = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'rotulo' field has been set.
      * @return True if the 'rotulo' field has been set, false otherwise.
      */
    public boolean hasRotulo() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'rotulo' field.
      * @return This builder.
      */
    public org.TFGInformatica.EstacionDeServicio.Builder clearRotulo() {
      rotulo = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EstacionDeServicio build() {
      try {
        EstacionDeServicio record = new EstacionDeServicio();
        record.direccion = fieldSetFlags()[0] ? this.direccion : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.municipio = fieldSetFlags()[1] ? this.municipio : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.localidad = fieldSetFlags()[2] ? this.localidad : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.codigoPostal = fieldSetFlags()[3] ? this.codigoPostal : (java.lang.Integer) defaultValue(fields()[3]);
        record.longitud = fieldSetFlags()[4] ? this.longitud : (java.lang.Float) defaultValue(fields()[4]);
        record.latitud = fieldSetFlags()[5] ? this.latitud : (java.lang.Float) defaultValue(fields()[5]);
        record.precioGasolina95 = fieldSetFlags()[6] ? this.precioGasolina95 : (java.lang.Float) defaultValue(fields()[6]);
        record.precioGasolina98 = fieldSetFlags()[7] ? this.precioGasolina98 : (java.lang.Float) defaultValue(fields()[7]);
        record.precioGasoleoA = fieldSetFlags()[8] ? this.precioGasoleoA : (java.lang.Float) defaultValue(fields()[8]);
        record.precioGasoleoPremium = fieldSetFlags()[9] ? this.precioGasoleoPremium : (java.lang.Float) defaultValue(fields()[9]);
        record.rotulo = fieldSetFlags()[10] ? this.rotulo : (java.lang.CharSequence) defaultValue(fields()[10]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EstacionDeServicio>
    WRITER$ = (org.apache.avro.io.DatumWriter<EstacionDeServicio>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EstacionDeServicio>
    READER$ = (org.apache.avro.io.DatumReader<EstacionDeServicio>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.direccion);

    out.writeString(this.municipio);

    out.writeString(this.localidad);

    out.writeInt(this.codigoPostal);

    out.writeFloat(this.longitud);

    out.writeFloat(this.latitud);

    out.writeFloat(this.precioGasolina95);

    out.writeFloat(this.precioGasolina98);

    out.writeFloat(this.precioGasoleoA);

    out.writeFloat(this.precioGasoleoPremium);

    out.writeString(this.rotulo);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.direccion = in.readString(this.direccion instanceof Utf8 ? (Utf8)this.direccion : null);

      this.municipio = in.readString(this.municipio instanceof Utf8 ? (Utf8)this.municipio : null);

      this.localidad = in.readString(this.localidad instanceof Utf8 ? (Utf8)this.localidad : null);

      this.codigoPostal = in.readInt();

      this.longitud = in.readFloat();

      this.latitud = in.readFloat();

      this.precioGasolina95 = in.readFloat();

      this.precioGasolina98 = in.readFloat();

      this.precioGasoleoA = in.readFloat();

      this.precioGasoleoPremium = in.readFloat();

      this.rotulo = in.readString(this.rotulo instanceof Utf8 ? (Utf8)this.rotulo : null);

    } else {
      for (int i = 0; i < 11; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.direccion = in.readString(this.direccion instanceof Utf8 ? (Utf8)this.direccion : null);
          break;

        case 1:
          this.municipio = in.readString(this.municipio instanceof Utf8 ? (Utf8)this.municipio : null);
          break;

        case 2:
          this.localidad = in.readString(this.localidad instanceof Utf8 ? (Utf8)this.localidad : null);
          break;

        case 3:
          this.codigoPostal = in.readInt();
          break;

        case 4:
          this.longitud = in.readFloat();
          break;

        case 5:
          this.latitud = in.readFloat();
          break;

        case 6:
          this.precioGasolina95 = in.readFloat();
          break;

        case 7:
          this.precioGasolina98 = in.readFloat();
          break;

        case 8:
          this.precioGasoleoA = in.readFloat();
          break;

        case 9:
          this.precioGasoleoPremium = in.readFloat();
          break;

        case 10:
          this.rotulo = in.readString(this.rotulo instanceof Utf8 ? (Utf8)this.rotulo : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










