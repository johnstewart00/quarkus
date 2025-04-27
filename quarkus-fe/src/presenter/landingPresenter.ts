"use server";

import { cookies } from "next/headers";

export const getCartData = async () => {
  const cookieStore = await cookies();
  const userID = cookieStore.get("userID")?.value;
  return await fetch(`http://localhost:8080/cart?userID=${userID}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
    },
  });
};

export const addToCart = async (item: string) => {
  const cookieStore = await cookies();
  const userID = cookieStore.get("userID")?.value;
  const res = await fetch("http://localhost:8080/cart", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
    },
    credentials: "include",
    body: JSON.stringify({
      id: crypto.randomUUID(),
      name: item,
      userID: userID,
    }),
  });
  const data = await res.json();
  return data;
};
