import React from "react";

function Search(props) {
  return (
    <div>
      <input
        className="py-1 px-3 rounded border border-secondary"
        type="text"
        onChange={props.updateSearchState}
        placeholder="Search..."
      />
    </div>
  );
}

export default Search;
