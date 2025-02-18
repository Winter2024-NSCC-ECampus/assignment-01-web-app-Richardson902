import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import dns from "node:dns";

dns.setDefaultResultOrder("verbatim");

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/todo/api/": {
        target: "http://build-api:8080",
        changeOrigin: true,
        secure: false,
      },
    },
  },
});
