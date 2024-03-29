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
public class TraficoPuntoDeMedicion extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3968032610415282310L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TraficoPuntoDeMedicion\",\"namespace\":\"org.TFGInformatica\",\"fields\":[{\"name\":\"idelem\",\"type\":\"int\"},{\"name\":\"descripcion\",\"type\":\"string\"},{\"name\":\"intensidad\",\"type\":[\"int\",\"null\"]},{\"name\":\"carga\",\"type\":[\"int\",\"null\"]},{\"name\":\"nivelServicio\",\"type\":[\"int\",\"null\"]},{\"name\":\"distrito\",\"type\":\"int\"},{\"name\":\"fechaActualizacion\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TraficoPuntoDeMedicion> ENCODER =
      new BinaryMessageEncoder<TraficoPuntoDeMedicion>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TraficoPuntoDeMedicion> DECODER =
      new BinaryMessageDecoder<TraficoPuntoDeMedicion>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TraficoPuntoDeMedicion> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TraficoPuntoDeMedicion> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TraficoPuntoDeMedicion> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TraficoPuntoDeMedicion>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TraficoPuntoDeMedicion to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TraficoPuntoDeMedicion from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TraficoPuntoDeMedicion instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TraficoPuntoDeMedicion fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private int idelem;
   private java.lang.CharSequence descripcion;
   private java.lang.Integer intensidad;
   private java.lang.Integer carga;
   private java.lang.Integer nivelServicio;
   private int distrito;
   private java.lang.CharSequence fechaActualizacion;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TraficoPuntoDeMedicion() {}

  /**
   * All-args constructor.
   * @param idelem The new value for idelem
   * @param descripcion The new value for descripcion
   * @param intensidad The new value for intensidad
   * @param carga The new value for carga
   * @param nivelServicio The new value for nivelServicio
   * @param distrito The new value for distrito
   * @param fechaActualizacion The new value for fechaActualizacion
   */
  public TraficoPuntoDeMedicion(java.lang.Integer idelem, java.lang.CharSequence descripcion, java.lang.Integer intensidad, java.lang.Integer carga, java.lang.Integer nivelServicio, java.lang.Integer distrito, java.lang.CharSequence fechaActualizacion) {
    this.idelem = idelem;
    this.descripcion = descripcion;
    this.intensidad = intensidad;
    this.carga = carga;
    this.nivelServicio = nivelServicio;
    this.distrito = distrito;
    this.fechaActualizacion = fechaActualizacion;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return idelem;
    case 1: return descripcion;
    case 2: return intensidad;
    case 3: return carga;
    case 4: return nivelServicio;
    case 5: return distrito;
    case 6: return fechaActualizacion;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: idelem = (java.lang.Integer)value$; break;
    case 1: descripcion = (java.lang.CharSequence)value$; break;
    case 2: intensidad = (java.lang.Integer)value$; break;
    case 3: carga = (java.lang.Integer)value$; break;
    case 4: nivelServicio = (java.lang.Integer)value$; break;
    case 5: distrito = (java.lang.Integer)value$; break;
    case 6: fechaActualizacion = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'idelem' field.
   * @return The value of the 'idelem' field.
   */
  public int getIdelem() {
    return idelem;
  }


  /**
   * Sets the value of the 'idelem' field.
   * @param value the value to set.
   */
  public void setIdelem(int value) {
    this.idelem = value;
  }

  /**
   * Gets the value of the 'descripcion' field.
   * @return The value of the 'descripcion' field.
   */
  public java.lang.CharSequence getDescripcion() {
    return descripcion;
  }


  /**
   * Sets the value of the 'descripcion' field.
   * @param value the value to set.
   */
  public void setDescripcion(java.lang.CharSequence value) {
    this.descripcion = value;
  }

  /**
   * Gets the value of the 'intensidad' field.
   * @return The value of the 'intensidad' field.
   */
  public java.lang.Integer getIntensidad() {
    return intensidad;
  }


  /**
   * Sets the value of the 'intensidad' field.
   * @param value the value to set.
   */
  public void setIntensidad(java.lang.Integer value) {
    this.intensidad = value;
  }

  /**
   * Gets the value of the 'carga' field.
   * @return The value of the 'carga' field.
   */
  public java.lang.Integer getCarga() {
    return carga;
  }


  /**
   * Sets the value of the 'carga' field.
   * @param value the value to set.
   */
  public void setCarga(java.lang.Integer value) {
    this.carga = value;
  }

  /**
   * Gets the value of the 'nivelServicio' field.
   * @return The value of the 'nivelServicio' field.
   */
  public java.lang.Integer getNivelServicio() {
    return nivelServicio;
  }


  /**
   * Sets the value of the 'nivelServicio' field.
   * @param value the value to set.
   */
  public void setNivelServicio(java.lang.Integer value) {
    this.nivelServicio = value;
  }

  /**
   * Gets the value of the 'distrito' field.
   * @return The value of the 'distrito' field.
   */
  public int getDistrito() {
    return distrito;
  }


  /**
   * Sets the value of the 'distrito' field.
   * @param value the value to set.
   */
  public void setDistrito(int value) {
    this.distrito = value;
  }

  /**
   * Gets the value of the 'fechaActualizacion' field.
   * @return The value of the 'fechaActualizacion' field.
   */
  public java.lang.CharSequence getFechaActualizacion() {
    return fechaActualizacion;
  }


  /**
   * Sets the value of the 'fechaActualizacion' field.
   * @param value the value to set.
   */
  public void setFechaActualizacion(java.lang.CharSequence value) {
    this.fechaActualizacion = value;
  }

  /**
   * Creates a new TraficoPuntoDeMedicion RecordBuilder.
   * @return A new TraficoPuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.TraficoPuntoDeMedicion.Builder newBuilder() {
    return new org.TFGInformatica.TraficoPuntoDeMedicion.Builder();
  }

  /**
   * Creates a new TraficoPuntoDeMedicion RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TraficoPuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.TraficoPuntoDeMedicion.Builder newBuilder(org.TFGInformatica.TraficoPuntoDeMedicion.Builder other) {
    if (other == null) {
      return new org.TFGInformatica.TraficoPuntoDeMedicion.Builder();
    } else {
      return new org.TFGInformatica.TraficoPuntoDeMedicion.Builder(other);
    }
  }

  /**
   * Creates a new TraficoPuntoDeMedicion RecordBuilder by copying an existing TraficoPuntoDeMedicion instance.
   * @param other The existing instance to copy.
   * @return A new TraficoPuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.TraficoPuntoDeMedicion.Builder newBuilder(org.TFGInformatica.TraficoPuntoDeMedicion other) {
    if (other == null) {
      return new org.TFGInformatica.TraficoPuntoDeMedicion.Builder();
    } else {
      return new org.TFGInformatica.TraficoPuntoDeMedicion.Builder(other);
    }
  }

  /**
   * RecordBuilder for TraficoPuntoDeMedicion instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TraficoPuntoDeMedicion>
    implements org.apache.avro.data.RecordBuilder<TraficoPuntoDeMedicion> {

    private int idelem;
    private java.lang.CharSequence descripcion;
    private java.lang.Integer intensidad;
    private java.lang.Integer carga;
    private java.lang.Integer nivelServicio;
    private int distrito;
    private java.lang.CharSequence fechaActualizacion;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.TFGInformatica.TraficoPuntoDeMedicion.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.idelem)) {
        this.idelem = data().deepCopy(fields()[0].schema(), other.idelem);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.descripcion)) {
        this.descripcion = data().deepCopy(fields()[1].schema(), other.descripcion);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.intensidad)) {
        this.intensidad = data().deepCopy(fields()[2].schema(), other.intensidad);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.carga)) {
        this.carga = data().deepCopy(fields()[3].schema(), other.carga);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.nivelServicio)) {
        this.nivelServicio = data().deepCopy(fields()[4].schema(), other.nivelServicio);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.distrito)) {
        this.distrito = data().deepCopy(fields()[5].schema(), other.distrito);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.fechaActualizacion)) {
        this.fechaActualizacion = data().deepCopy(fields()[6].schema(), other.fechaActualizacion);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing TraficoPuntoDeMedicion instance
     * @param other The existing instance to copy.
     */
    private Builder(org.TFGInformatica.TraficoPuntoDeMedicion other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.idelem)) {
        this.idelem = data().deepCopy(fields()[0].schema(), other.idelem);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.descripcion)) {
        this.descripcion = data().deepCopy(fields()[1].schema(), other.descripcion);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.intensidad)) {
        this.intensidad = data().deepCopy(fields()[2].schema(), other.intensidad);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.carga)) {
        this.carga = data().deepCopy(fields()[3].schema(), other.carga);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.nivelServicio)) {
        this.nivelServicio = data().deepCopy(fields()[4].schema(), other.nivelServicio);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.distrito)) {
        this.distrito = data().deepCopy(fields()[5].schema(), other.distrito);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.fechaActualizacion)) {
        this.fechaActualizacion = data().deepCopy(fields()[6].schema(), other.fechaActualizacion);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'idelem' field.
      * @return The value.
      */
    public int getIdelem() {
      return idelem;
    }


    /**
      * Sets the value of the 'idelem' field.
      * @param value The value of 'idelem'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setIdelem(int value) {
      validate(fields()[0], value);
      this.idelem = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'idelem' field has been set.
      * @return True if the 'idelem' field has been set, false otherwise.
      */
    public boolean hasIdelem() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'idelem' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearIdelem() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'descripcion' field.
      * @return The value.
      */
    public java.lang.CharSequence getDescripcion() {
      return descripcion;
    }


    /**
      * Sets the value of the 'descripcion' field.
      * @param value The value of 'descripcion'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setDescripcion(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.descripcion = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'descripcion' field has been set.
      * @return True if the 'descripcion' field has been set, false otherwise.
      */
    public boolean hasDescripcion() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'descripcion' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearDescripcion() {
      descripcion = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'intensidad' field.
      * @return The value.
      */
    public java.lang.Integer getIntensidad() {
      return intensidad;
    }


    /**
      * Sets the value of the 'intensidad' field.
      * @param value The value of 'intensidad'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setIntensidad(java.lang.Integer value) {
      validate(fields()[2], value);
      this.intensidad = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'intensidad' field has been set.
      * @return True if the 'intensidad' field has been set, false otherwise.
      */
    public boolean hasIntensidad() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'intensidad' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearIntensidad() {
      intensidad = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'carga' field.
      * @return The value.
      */
    public java.lang.Integer getCarga() {
      return carga;
    }


    /**
      * Sets the value of the 'carga' field.
      * @param value The value of 'carga'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setCarga(java.lang.Integer value) {
      validate(fields()[3], value);
      this.carga = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'carga' field has been set.
      * @return True if the 'carga' field has been set, false otherwise.
      */
    public boolean hasCarga() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'carga' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearCarga() {
      carga = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'nivelServicio' field.
      * @return The value.
      */
    public java.lang.Integer getNivelServicio() {
      return nivelServicio;
    }


    /**
      * Sets the value of the 'nivelServicio' field.
      * @param value The value of 'nivelServicio'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setNivelServicio(java.lang.Integer value) {
      validate(fields()[4], value);
      this.nivelServicio = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'nivelServicio' field has been set.
      * @return True if the 'nivelServicio' field has been set, false otherwise.
      */
    public boolean hasNivelServicio() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'nivelServicio' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearNivelServicio() {
      nivelServicio = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'distrito' field.
      * @return The value.
      */
    public int getDistrito() {
      return distrito;
    }


    /**
      * Sets the value of the 'distrito' field.
      * @param value The value of 'distrito'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setDistrito(int value) {
      validate(fields()[5], value);
      this.distrito = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'distrito' field has been set.
      * @return True if the 'distrito' field has been set, false otherwise.
      */
    public boolean hasDistrito() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'distrito' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearDistrito() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'fechaActualizacion' field.
      * @return The value.
      */
    public java.lang.CharSequence getFechaActualizacion() {
      return fechaActualizacion;
    }


    /**
      * Sets the value of the 'fechaActualizacion' field.
      * @param value The value of 'fechaActualizacion'.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder setFechaActualizacion(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.fechaActualizacion = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'fechaActualizacion' field has been set.
      * @return True if the 'fechaActualizacion' field has been set, false otherwise.
      */
    public boolean hasFechaActualizacion() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'fechaActualizacion' field.
      * @return This builder.
      */
    public org.TFGInformatica.TraficoPuntoDeMedicion.Builder clearFechaActualizacion() {
      fechaActualizacion = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TraficoPuntoDeMedicion build() {
      try {
        TraficoPuntoDeMedicion record = new TraficoPuntoDeMedicion();
        record.idelem = fieldSetFlags()[0] ? this.idelem : (java.lang.Integer) defaultValue(fields()[0]);
        record.descripcion = fieldSetFlags()[1] ? this.descripcion : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.intensidad = fieldSetFlags()[2] ? this.intensidad : (java.lang.Integer) defaultValue(fields()[2]);
        record.carga = fieldSetFlags()[3] ? this.carga : (java.lang.Integer) defaultValue(fields()[3]);
        record.nivelServicio = fieldSetFlags()[4] ? this.nivelServicio : (java.lang.Integer) defaultValue(fields()[4]);
        record.distrito = fieldSetFlags()[5] ? this.distrito : (java.lang.Integer) defaultValue(fields()[5]);
        record.fechaActualizacion = fieldSetFlags()[6] ? this.fechaActualizacion : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TraficoPuntoDeMedicion>
    WRITER$ = (org.apache.avro.io.DatumWriter<TraficoPuntoDeMedicion>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TraficoPuntoDeMedicion>
    READER$ = (org.apache.avro.io.DatumReader<TraficoPuntoDeMedicion>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.idelem);

    out.writeString(this.descripcion);

    if (this.intensidad == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.intensidad);
    }

    if (this.carga == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.carga);
    }

    if (this.nivelServicio == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeInt(this.nivelServicio);
    }

    out.writeInt(this.distrito);

    out.writeString(this.fechaActualizacion);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.idelem = in.readInt();

      this.descripcion = in.readString(this.descripcion instanceof Utf8 ? (Utf8)this.descripcion : null);

      if (in.readIndex() != 0) {
        in.readNull();
        this.intensidad = null;
      } else {
        this.intensidad = in.readInt();
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.carga = null;
      } else {
        this.carga = in.readInt();
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.nivelServicio = null;
      } else {
        this.nivelServicio = in.readInt();
      }

      this.distrito = in.readInt();

      this.fechaActualizacion = in.readString(this.fechaActualizacion instanceof Utf8 ? (Utf8)this.fechaActualizacion : null);

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.idelem = in.readInt();
          break;

        case 1:
          this.descripcion = in.readString(this.descripcion instanceof Utf8 ? (Utf8)this.descripcion : null);
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.intensidad = null;
          } else {
            this.intensidad = in.readInt();
          }
          break;

        case 3:
          if (in.readIndex() != 0) {
            in.readNull();
            this.carga = null;
          } else {
            this.carga = in.readInt();
          }
          break;

        case 4:
          if (in.readIndex() != 0) {
            in.readNull();
            this.nivelServicio = null;
          } else {
            this.nivelServicio = in.readInt();
          }
          break;

        case 5:
          this.distrito = in.readInt();
          break;

        case 6:
          this.fechaActualizacion = in.readString(this.fechaActualizacion instanceof Utf8 ? (Utf8)this.fechaActualizacion : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










