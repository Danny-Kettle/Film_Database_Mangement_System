import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./pages/Layout";
import NewFilm from "./pages/NewFilm";
import React, { useState, useEffect } from "react";
import SearchFilm from "./pages/SearchFilm";
import EditFilm from "./pages/EditFilm";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<SearchFilm />} />
        <Route path="new" element={<NewFilm />} />
        <Route path="edit" element={<EditFilm />} />
        {/* <Route path="*" element={<NoPage />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
