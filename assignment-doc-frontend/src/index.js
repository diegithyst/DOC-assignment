import "./index.css"
import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider, createHashRouter } from "react-router-dom"
import Departments from './routes/Departments.js';

const router = createHashRouter([
  {
    path: "/",
    element: <Departments />,
  },
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<RouterProvider router={router} />);