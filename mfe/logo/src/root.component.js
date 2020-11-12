import React from "react";

export default function Root(props) {
  return (
    <section>
      <div class="page-header">
        <h5>Eu sou o mfe {props.name}</h5>
        <p>Usuário autenticado: {localStorage.getItem("auth.subject")}</p>
      </div>
    </section>
  );
}
