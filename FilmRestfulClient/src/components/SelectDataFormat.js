import React from "react";
import Select from "react-select";

function SelectDataFormat(props) {
  const options = [
    { value: "json", label: "JSON" },
    { value: "xml", label: "XML" },
    { value: "string", label: "String" },
  ];

  return (
    <Select
      placeholder="Data Format..."
      onChange={props.changeDataFormat}
      options={options}
    ></Select>
  );
}

export default SelectDataFormat;
