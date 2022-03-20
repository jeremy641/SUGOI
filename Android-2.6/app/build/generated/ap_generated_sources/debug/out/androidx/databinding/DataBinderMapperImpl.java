package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.droideve.apps.sugoi.DataBinderMapperImpl());
  }
}
